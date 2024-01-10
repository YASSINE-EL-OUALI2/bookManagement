package com.yassine.test.springbootDemo.services;

import com.yassine.test.springbootDemo.entity.Authors;
import com.yassine.test.springbootDemo.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsService {

    @Autowired
    AuthorsRepository authorsRepository;

    public Authors addAuthor(Authors book) {
        return authorsRepository.save(book);
    }

    public List<Authors> getAuthors() {
        return authorsRepository.findAll();
    }

    public Optional<Authors> getAuthorById(Long id) {
        return authorsRepository.findById(id);
    }

    public void updateAuthor(Authors author) {
        authorsRepository.save(author);
    }

    public void deleteAuthor(Authors author) {
        authorsRepository.delete(author);
    }

    // same thing for other functions
}
