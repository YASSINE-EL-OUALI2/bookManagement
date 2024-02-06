package com.yassine.test.springbootDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorid")
    private Long authorId;
    @Column(name = "authorname", unique = true)
    private String authorName;
    @Column(name = "biography")
    private String biography;
    //@JsonIgnoreProperties("author")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "author")
    @JsonIgnoreProperties("author")
    //@JoinColumn(name = "bookid")
    private List<Books> books;

    public Authors() {
    }

    public Authors(String authorName, String biography, List<Books> books) {
        this.authorName = authorName;
        this.biography = biography;
        this.books = books;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", biography='" + biography + '\'' +
                ", books=" + books +
                '}';
    }
}
