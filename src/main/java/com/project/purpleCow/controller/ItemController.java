package com.project.purpleCow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.purpleCow.models.Item;
import com.project.purpleCow.repository.ItemRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    
}
