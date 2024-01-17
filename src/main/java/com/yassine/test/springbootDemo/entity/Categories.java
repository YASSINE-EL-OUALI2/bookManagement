package com.yassine.test.springbootDemo.entity;

import jakarta.persistence.*;

@Entity(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categoryid")
    private Long categoryId;

    @Column(name="categoryname")
    private String categoryName;

    @Column(name = "description")
    private String description;

    public Categories() {
    }

    public Categories(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
