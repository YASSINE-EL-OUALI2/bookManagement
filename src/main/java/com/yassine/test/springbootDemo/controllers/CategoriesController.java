package com.yassine.test.springbootDemo.controllers;

import com.yassine.test.springbootDemo.entity.Categories;
import com.yassine.test.springbootDemo.services.CategoriesService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/api/categories")
@SecurityRequirement(name = "bearerAuth")

public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/getall")
    public List<Categories> getCategories() {
        return categoriesService.getCategories();
    }

    // save category
    @PostMapping("/addcategory")
    public void addCategory(@RequestBody Categories category) {
        categoriesService.addCategory(category);
    }

    // get category by Id
    @GetMapping("/getbyid")
    public Categories getCategoryById(@RequestParam(value = "id") Long id) {
        return categoriesService.getCategoryById(id);
    }

    // update category
    @PutMapping(value = "/updatecategory", consumes = "application/json", produces = "application/json")
    public Categories updateBook(@RequestBody Categories category) {
        return categoriesService.updateCategory(category);
    }

    // delete category
    @DeleteMapping(value = "/deletecategory", consumes = "application/json")
    public void deleteBook(@RequestBody Categories category) {
        categoriesService.deleteCategory(category);
    }

}
