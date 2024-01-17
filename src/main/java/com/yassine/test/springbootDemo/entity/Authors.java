package com.yassine.test.springbootDemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorid")
    private Long authorId;
    @Column(name = "authorname")
    private String authorName;
    @Column(name = "biography")
    private String biography;
    @OneToMany
    @JoinColumn(name = "bookid")
    private List<Books> books;

    public Authors() {
    }

    public Authors(String authorName, String biography, List<Books> books) {
        this.authorName = authorName;
        this.biography = biography;
        this.books = books;
    }

    public Long authorId() {
        return authorId;
    }

    public String authorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String biography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Books> books() {
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
