package com.yassine.test.springbootDemo.controllers;

import com.yassine.test.springbootDemo.entity.Inventory;
import com.yassine.test.springbootDemo.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/inventory")
public class InventoryController {


    @Autowired
    InventoryService inventoryService;

    //get inventory
    @GetMapping("/getall")
    public List<Inventory> getInventory() {
        return inventoryService.getInventory();
    }

    // add Item
    @PostMapping("/additem")
    public void addItem(@RequestBody Inventory inventory) {
        inventoryService.addInventory(inventory);
    }

    // get Item by Id
    @GetMapping("/getitembyid")
    public Optional<Inventory> getItemById(@RequestParam(value = "id") Long id) {
        return inventoryService.getInventoryById(id);
    }

    // update inventory
    @PutMapping(value = "/updateinventory", consumes = "application/json", produces = "application/json")
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        return inventoryService.updateInventory(inventory);
    }

    // delete inventory
    @DeleteMapping(value = "/deleteinventory", consumes = "application/json")
    public void deleteInventory(@RequestBody Inventory inventory) {
        inventoryService.deleteInventory(inventory);
    }
}
