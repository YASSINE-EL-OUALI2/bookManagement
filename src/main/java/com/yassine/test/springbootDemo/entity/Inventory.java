package com.yassine.test.springbootDemo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inventoryid")
    private Long inventoryId;

    @OneToMany
    @JoinColumn(name = "bookid")
    private List<Books> books;
    @Column(name="dateadded")
    private Date dateAdded;
    @Column(name = "shelflocation")
    private String shelfLocation;
    @Column(name = "condition")
    private String condition;

    public Inventory() {
    }

    public Inventory(List<Books> books, Date dateAdded, String shelfLocation, String condition) {
        this.books = books;
        this.dateAdded = dateAdded;
        this.shelfLocation = shelfLocation;
        this.condition = condition;
    }

    public Long inventoryId() {
        return inventoryId;
    }

    public List<Books> books() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public Date dateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String shelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public String condition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}