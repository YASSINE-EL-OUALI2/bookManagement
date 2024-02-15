package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Inventory;
import com.yassine.test.springbootDemo.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/inventory")
public class InventoryController {

    
    @Autowired
    InventoryService inventoryService;
    //get inventory
    @GetMapping("/inventory/getall")
    public List<Inventory> getInventory(){
        return inventoryService.getInventory();
    }

    // add Item
    @PostMapping("/inventory/additem")
    public void addItem(@RequestBody Inventory inventory){
        inventoryService.addInventory(inventory);
    }
    // get Item by Id
    @GetMapping("/inventory/getitembyid")
    public Optional<Inventory> getItemById(@RequestParam(value = "id") Long id){
        return inventoryService.getInventoryById(id);
    }
    // update inventory
    @PutMapping(value = "/inventory/updateinventory", consumes = "application/json", produces = "application/json")
    public Inventory updateInventory(@RequestBody Inventory inventory){
        return inventoryService.updateInventory(inventory);
    }
    // delete inventory
    @DeleteMapping("/inventory/deleteinventory")
    public void deleteInventory(@RequestBody Inventory inventory){
        inventoryService.deleteInventory(inventory);
    }
}
