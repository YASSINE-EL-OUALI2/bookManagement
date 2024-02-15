package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Categories;
import com.yassine.test.springbootDemo.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;
    @GetMapping("/categories/getall")
    public List<Categories> getCategories(){
        return categoriesService.getCategories();
    }

    // save category
    @PostMapping("/categories/addcategory")
    public void addCategory(@RequestBody Categories category){
        categoriesService.addCategory(category);
    }
    // get category by Id
    @GetMapping("/categories/getbyid")
    public Optional<Categories> getCategoryById(@RequestParam(value = "id") Long id){
        return categoriesService.getCategoryById(id);
    }
    // update category
    @PutMapping(value = "/categories/updatecategory", consumes = "application/json", produces = "application/json")
    public Categories updateBook(@RequestBody Categories category){
        return categoriesService.updateCategory(category);
    }
    // delete category
    @DeleteMapping("/categories/deletebook")
    public void deleteBook(@RequestBody Categories category){
        categoriesService.deleteCategory(category);
    }

}
