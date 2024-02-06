package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Authors;
import com.yassine.test.springbootDemo.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("authors")
public class AuthorsController {

    @Autowired
    AuthorsService authorsService;

    @GetMapping("/authors/getall")
    public List<Authors> getAuthors() {
        return authorsService.getAuthors();
    }

    // save Author corrected
    @PostMapping("/authors/addauthor")
    public void addAuthor(@RequestBody Authors book) {
        authorsService.addAuthor(book);
    }

    // get author by Id
    @GetMapping("/authors/getbyid")
    public Optional<Authors> getAuthorById(@RequestParam(value = "id") Long id) {
        return authorsService.getAuthorById(id);
    }

    // update book
    @PutMapping("/authorsupdateauthor")
    public Authors updateAuthor(@RequestBody Authors author) {
        return authorsService.updateAuthor(author);
    }

    // delete book
    @DeleteMapping("/authors/deletebook")
    public void deleteAuthor(@RequestBody Authors author) {
        authorsService.deleteAuthor(author);
    }

}
