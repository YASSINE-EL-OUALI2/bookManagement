package com.yassine.test.springbootDemo.controllers;

import com.yassine.test.springbootDemo.entity.Books;
import com.yassine.test.springbootDemo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/getall")
    public List<Books> getBooks() {
        return booksService.getBooks();
    }

    // save book
    @PostMapping("/addbook")
    public void addBook(@RequestBody Books book) {
        booksService.addBook(book);
    }

    // get book by Id
    @GetMapping("/getbyid")
    public Books getBookById(@RequestParam(value = "id") Long id) {
        return booksService.getBookById(id);
    }

    // update book
    @PutMapping(value = "/updatebook", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Books> updateBook(@RequestBody Books book) {
        booksService.updateBook(book);
        return ResponseEntity.ok(book);
    }

    // delete book
    @DeleteMapping(value = "/deletebook", consumes = "application/json")
    public void deleteBook(@RequestBody Books book) {
        booksService.deleteBook(book);
    }

    // check Threshold
    @GetMapping("/books/checkthreshold")
    public ResponseEntity<String> checkThreshold(@RequestParam(value = "id") Long id) {
        Optional<Books> bookFnd = Optional.ofNullable(booksService.getBookById(id));
        if (bookFnd.isPresent()) {
            int threshold = 5;
            Books book = bookFnd.get();
            if (book.getQuantityAvailable() < threshold) {
                return ResponseEntity.ok("Book quantity below threshold.");
            } else {
                return ResponseEntity.ok("Book quantity above threshold.");

            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
