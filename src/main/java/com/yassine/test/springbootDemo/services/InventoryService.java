package com.yassine.test.springbootDemo.services;

import com.yassine.test.springbootDemo.entity.Inventory;
import com.yassine.test.springbootDemo.errorHandling.InventoriesException;
import com.yassine.test.springbootDemo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoriesException("Inventory Not Found !"));
    }

    public Inventory updateInventory(Inventory inventory) {
        Inventory existingInventory = inventoryRepository.findById(inventory.getInventoryId())
                .orElseThrow(() -> new InventoriesException("Inventory Not Found !"));
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
