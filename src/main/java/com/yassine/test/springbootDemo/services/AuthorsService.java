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

    public void addAuthor(Authors author) {
        authorsRepository.save(author);
    }

    public List<Authors> getAuthors() {
        return authorsRepository.findAll();
    }

    public Optional<Authors> getAuthorById(Long id) {
        return authorsRepository.findById(id);
    }

    public Authors updateAuthor(Authors author) {
        Authors existingAuthors = authorsRepository.findById(author.getAuthorId()).orElse(null);
        if (existingAuthors != null) {
            return authorsRepository.save(existingAuthors);
        }
        return null;


    }

    public void deleteAuthor(Authors author) {
        authorsRepository.delete(author);
    }

}
