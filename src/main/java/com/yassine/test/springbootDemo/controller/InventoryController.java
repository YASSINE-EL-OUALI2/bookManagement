package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Inventory;
import com.yassine.test.springbootDemo.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    
    @Autowired
    InventoryService inventoryService;
    //get inventory
    @GetMapping("/getall")
    public List<Inventory> getInventory(){
        return inventoryService.getInventory();
    }

    // add Item
    @PostMapping("/additem")
    public void addItem(Inventory inventory){
        inventoryService.addInventory(inventory);
    }
    // get Item by Id
    @GetMapping("getitembyid")
    public Optional<Inventory> getItemById(Long id){
        return inventoryService.getInventoryById(id);
    }
    // update inventory
    @PostMapping("updateinventory")
    public Inventory updateInventory(Inventory inventory){
        return inventoryService.updateInventory(inventory);
    }
    // delete inventory
    @PostMapping("deleteinventory")
    public void deleteInventory(Inventory inventory){
        inventoryService.deleteInventory(inventory);
    }
}
