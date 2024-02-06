package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Books;
import com.yassine.test.springbootDemo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/books/getall")
    public List<Books> getBooks() {
        return booksService.getBooks();
    }

    // save book
    @PostMapping("/books/addbook")
    public void addBook(@RequestBody Books book) {
        booksService.addBook(book);
    }

    // get book by Id
    @GetMapping("/books/getbyid")
    public Books getBookById(@RequestParam(value = "id") Long id) {
        return booksService.getBookById(id);
    }

    // update book
    @PutMapping(value = "/books/updatebook", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Books> updateBook(@RequestBody Books book) {
        booksService.updateBook(book);
        return ResponseEntity.ok(book);
    }

    // delete book
    @DeleteMapping("/books/deletebook")
    public void deleteBook(@RequestBody Books book) {
        booksService.deleteBook(book);
    }

}
