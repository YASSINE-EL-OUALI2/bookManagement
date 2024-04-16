package com.yassine.test.springbootDemo.services;

import com.yassine.test.springbootDemo.entity.Categories;
import com.yassine.test.springbootDemo.errorHandling.CategoriesException;
import com.yassine.test.springbootDemo.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Categories getCategoryById(Long id) {
        return categoriesRepository.findById(id)
        .orElseThrow(() -> new CategoriesException("Category Not Found !"));
    }

    public Categories updateCategory(Categories category) {
        Categories existingCategories = categoriesRepository.findById(category.getCategoryId()).orElse(null);
        if (existingCategories != null) {
            existingCategories.setCategoryName(category.getCategoryName());
            existingCategories.setDescription(category.getDescription());
            return categoriesRepository.save(existingCategories);
        }
        return null;
    }

    public void deleteCategory(Categories category) {
        categoriesRepository.delete(category);
    }

}
