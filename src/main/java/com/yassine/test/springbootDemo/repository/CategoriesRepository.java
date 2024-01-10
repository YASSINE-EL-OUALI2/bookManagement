package com.yassine.test.springbootDemo.repository;

import com.yassine.test.springbootDemo.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
