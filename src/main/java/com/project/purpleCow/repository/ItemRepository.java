package com.project.purpleCow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.purpleCow.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
