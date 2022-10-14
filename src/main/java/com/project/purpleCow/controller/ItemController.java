package com.project.purpleCow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.purpleCow.models.Item;
import com.project.purpleCow.repository.ItemRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "items")
public class ItemController {
    @Autowired
    ItemRepository repository;
    
    @GetMapping(value = "")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = repository.findAll();

        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

    @PostMapping(value = "/update-all")
    public ResponseEntity<List<Item>> setAllItems(@RequestBody List<Item> items){
        repository.saveAll(items);

        return new ResponseEntity<List<Item>>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete-all")
    public ResponseEntity<List<Item>> deleteAllItems(){
        repository.deleteAll();
        
        return new ResponseEntity<List<Item>>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id){
        Item item = repository.findById(id).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Item " + id.toString() + " not found"));
        
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Item> setItem(@PathVariable Long id, @RequestBody Item newItem){
        Item updatedItem = repository.findById(id).map(item -> {
            item.setName(newItem.getName());
            return repository.save(item);
        }).orElseThrow(() -> 
        new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Item for " + id.toString() + " not created"));

        return new ResponseEntity<>(updatedItem, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable Long id){
        repository.deleteById(id);

        return new ResponseEntity<Item>(HttpStatus.ACCEPTED);
    }
    
}
