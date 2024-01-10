package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Authors;
import com.yassine.test.springbootDemo.repository.AuthorsRepository;
import com.yassine.test.springbootDemo.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("authors")
public class AuthorsController {

    @Autowired
    AuthorsService authorsService;

    @GetMapping("/getall")
    public List<Authors> getAuthors() {
        return authorsService.getAuthors();
    }

    // save Author corrected
    @PostMapping("/addauthor")
    public Authors addAuthor(Authors book) {
        return authorsService.addAuthor(book);
    }

    // get author by Id
    @GetMapping("getbyid")
    public Optional<Authors> getAuthorById(Long id) {
        return authorsService.getAuthorById(id);
    }

    // update book
    @PostMapping("updateauthor")
    public void updateAuthor(Authors author) {
        authorsService.updateAuthor(author);
    }

    // delete book
    @PostMapping("deletebook")
    public void deleteAuthor(Authors author) {
        authorsService.deleteAuthor(author);
    }

}
