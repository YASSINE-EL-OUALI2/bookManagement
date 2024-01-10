package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Categories;
import com.yassine.test.springbootDemo.repository.CategoriesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    CategoriesRepository categoriesRepository;

    @GetMapping("/getall")
    public List<Categories> getCategories(){
        return categoriesRepository.findAll();
    }

    // save category
    @PostMapping("/addcategory")
    public void addCategory(Categories category){
        categoriesRepository.save(category);
    }
    // get category by Id
    @GetMapping("getbyid")
    public Optional<Categories> getCategoryById(Long id){
        return categoriesRepository.findById(id);
    }
    // update category
    @PostMapping("updatecategory")
    public void updateBook(Categories category){
        categoriesRepository.save(category);
    }
    // delete category
    @PostMapping("deletebook")
    public void deleteBook(Categories category){
        categoriesRepository.delete(category);
    }

}
