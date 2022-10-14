package com.project.purpleCow.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.purpleCow.models.Item;

@Configuration
public class LoadItems {
    private static final Logger log = LoggerFactory.getLogger(LoadItems.class);

    //Preload Data on Application start
    @Bean
    CommandLineRunner initDatabase(ItemRepository repository) {
  
      return args -> {
        log.info("Preloading " + repository.save(new Item("Mask")));
        log.info("Preloading " + repository.save(new Item( "Glove")));
      };
    }
}

