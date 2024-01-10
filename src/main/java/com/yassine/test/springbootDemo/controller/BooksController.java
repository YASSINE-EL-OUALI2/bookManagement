package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Books;
import com.yassine.test.springbootDemo.repository.BooksRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    BooksRepository booksRepository;

    @GetMapping("/getall")
    public List<Books> getBooks(){
        return booksRepository.findAll();
    }

    // save book
    @PostMapping("/addbook")
    public void addBook(Books book){
        booksRepository.save(book);
    }
    // get book by Id
    @GetMapping("getbyid")
    public Optional<Books> getBookById(Long id){
        return booksRepository.findById(id);
    }
    // update book
    @PostMapping("updatebook")
    public void updateBook(Books book){
        booksRepository.save(book);
    }
    // delete book
    @PostMapping("deletebook")
    public void deleteBook(Books book){
        booksRepository.delete(book);
    }

}
