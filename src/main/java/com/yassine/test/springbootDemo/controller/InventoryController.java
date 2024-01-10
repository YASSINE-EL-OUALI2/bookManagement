package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Inventory;
import com.yassine.test.springbootDemo.repository.InventoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    InventoryRepository inventoryRepository;

    //get inventory
    @GetMapping("/getall")
    public List<Inventory> getInventory(){
        return inventoryRepository.findAll();
    }

    // add Item
    @PostMapping("/additem")
    public void addItem(Inventory inventory){
        inventoryRepository.save(inventory);
    }
    // get Item by Id
    @GetMapping("getitembyid")
    public Optional<Inventory> getItemById(Long id){
        return inventoryRepository.findById(id);
    }
    // update inventory
    @PostMapping("updateinventory")
    public void updateInventory(Inventory inventory){
        inventoryRepository.save(inventory);
    }
    // delete inventory
    @PostMapping("deleteinventory")
    public void deleteInventory(Inventory inventory){
        inventoryRepository.delete(inventory);
    }
}
