package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Categories;
import com.yassine.test.springbootDemo.repository.CategoriesRepository;
import com.yassine.test.springbootDemo.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;
    @GetMapping("/getall")
    public List<Categories> getCategories(){
        return categoriesService.getCategories();
    }

    // save category
    @PostMapping("/addcategory")
    public void addCategory(Categories category){
        categoriesService.addCategory(category);
    }
    // get category by Id
    @GetMapping("getbyid")
    public Optional<Categories> getCategoryById(Long id){
        return categoriesService.getCategoryById(id);
    }
    // update category
    @PostMapping("updatecategory")
    public Categories updateBook(Categories category){
        return categoriesService.updateCategory(category);
    }
    // delete category
    @PostMapping("deletebook")
    public void deleteBook(Categories category){
        categoriesService.deleteCategory(category);
    }

}
