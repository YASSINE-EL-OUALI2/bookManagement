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

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", category=" + category +
                ", inventory=" + inventory +
                ", isbn='" + isbn + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", publicationYear=" + publicationYear +
                ", quantityAvailable=" + quantityAvailable +
                ", price=" + price +
                '}';
    }
}
