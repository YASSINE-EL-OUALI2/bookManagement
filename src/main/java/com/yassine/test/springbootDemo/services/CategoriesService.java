package com.yassine.test.springbootDemo.services;

import com.yassine.test.springbootDemo.entity.Categories;
import com.yassine.test.springbootDemo.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;

    public void addCategory(Categories category) {
        categoriesRepository.save(category);
    }

    public List<Categories> getCategories() {
        return categoriesRepository.findAll();
    }

    public Optional<Categories> getCategoryById(Long id) {
        return categoriesRepository.findById(id);
    }

    public Categories updateCategory(Categories category) {
        Categories existingCategories = categoriesRepository.findById(category.categoryId()).orElse(null);
        if (existingCategories != null) {
            return categoriesRepository.save(category);
        }
        return null;
    }

    public void deleteCategory(Categories category) {
        categoriesRepository.delete(category);
    }

}
