package com.yassine.test.springbootDemo.controllers;

import com.yassine.test.springbootDemo.entity.Authors;
import com.yassine.test.springbootDemo.services.AuthorsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/api/authors")
@SecurityRequirement(name = "bearerAuth")
public class AuthorsController {

    @Autowired
    AuthorsService authorsService;

    @GetMapping("/getall")
    public List<Authors> getAuthors() {
        return authorsService.getAuthors();
    }

    // save Author corrected
    @PostMapping("/addauthor")
    public void addAuthor(@RequestBody Authors book) {
        authorsService.addAuthor(book);
    }

    // get author by Id
    @GetMapping("/getbyid")
    public Optional<Authors> getAuthorById(@RequestParam(value = "id") Long id) {
        return authorsService.getAuthorById(id);
    }

    // update book
    @PutMapping(value = "/updateauthor", consumes = "application/json", produces = "application/json")
    public Authors updateAuthor(@RequestBody Authors author) {
        return authorsService.updateAuthor(author);
    }

    // delete book
    @DeleteMapping(value = "/deleteauthor", consumes = "application/json")
    public void deleteAuthor(@RequestBody Authors author) {
        authorsService.deleteAuthor(author);
    }

}
