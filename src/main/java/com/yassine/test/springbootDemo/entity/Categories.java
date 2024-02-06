package com.yassine.test.springbootDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

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
    //@JsonIgnoreProperties("category")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
    @JsonIgnoreProperties("category")
    //@JoinColumn(name = "bookid")
    private List<Books> books;

    public Categories() {
    }

    public Categories(String categoryName, String description, List<Books> books) {
        this.categoryName = categoryName;
        this.description = description;
        this.books = books;
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

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
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
