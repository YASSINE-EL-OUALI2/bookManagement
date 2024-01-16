package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Books;
import com.yassine.test.springbootDemo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/getall")
    public List<Books> getBooks() {
        return booksService.getBooks();
    }

    // save book
    @PostMapping("/addbook")
    public void addBook(Books book) {
        booksService.addBook(book);
    }

    // get book by Id
    @GetMapping("getbyid")
    public Optional<Books> getBookById(Long id) {
        return booksService.getBookById(id);
    }

    // update book
    @PostMapping("updatebook")
    public Books updateBook(Books book) {
        return booksService.updateBook(book);
    }

    // delete book
    @PostMapping("deletebook")
    public void deleteBook(Books book) {
        booksService.deleteBook(book);
    }

}
