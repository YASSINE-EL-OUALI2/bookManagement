package com.yassine.test.springbootDemo.services;

import com.yassine.test.springbootDemo.entity.Inventory;
import com.yassine.test.springbootDemo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public void addInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(Long id) {
        return inventoryRepository.findById(id);
    }

    public Inventory updateInventory(Inventory inventory) {
        Inventory existingInventory = inventoryRepository.findById(inventory.getInventoryId()).orElse(null);
        if (existingInventory != null) {
            existingInventory.setCondition(inventory.getCondition());
            existingInventory.setDateAdded(inventory.getDateAdded());
            existingInventory.setShelfLocation(inventory.getShelfLocation());
            return inventoryRepository.save(existingInventory);
        }
        return null;
    }

    public void deleteInventory(Inventory inventory) {
        inventoryRepository.delete(inventory);
    }

}
