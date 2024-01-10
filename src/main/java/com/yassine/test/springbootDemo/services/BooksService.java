package com.yassine.test.springbootDemo.services;

import com.yassine.test.springbootDemo.entity.Books;
import com.yassine.test.springbootDemo.entity.Books;
import com.yassine.test.springbootDemo.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;

    public void addBook(Books book) {
        booksRepository.save(book);
    }

    public List<Books> getBooks() {
        return booksRepository.findAll();
    }

    public Optional<Books> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    public Books updateBook(Books book) {
        Books existingBooks = booksRepository.findById(book.bookId()).orElse(null);
        if (existingBooks != null) {
            return booksRepository.save(book);
        }
        return null;
    }

    public void deleteBook(Books book) {
        booksRepository.delete(book);
    }

}
