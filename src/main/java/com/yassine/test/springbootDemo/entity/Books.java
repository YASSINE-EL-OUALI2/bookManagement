package com.yassine.test.springbootDemo.entity;

import jakarta.persistence.*;

@Entity(name="books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bookid")
    private Long bookId;
    @Column(name="title")
    private String title;
    @ManyToOne
    @JoinColumn(name="authorid")
    private Authors author;
    @ManyToOne
    @JoinColumn(name="categoryid")
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "inventoryid")
    private Inventory inventory;
    @Column(name="isbn")
    private String isbn;


    @Column(name="publisherName")
    private String publisherName;


    @Column(name="publicationYear")
    private int publicationYear;
    @Column(name="quantityAvailable")
    private int quantityAvailable;
    @Column(name="price")
    private float price;


    public Books(String title, Authors author, Categories category, Inventory inventory, String isbn, String publisherName, int publicationYear, int quantityAvailable, float price) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.inventory = inventory;
        this.isbn = isbn;
        this.publisherName = publisherName;
        this.publicationYear = publicationYear;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
    }

    public Books() {
    }

    public Long bookId() {
        return bookId;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Authors author() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public Categories category() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Inventory inventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String isbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String publisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int publicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int quantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public float price() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
