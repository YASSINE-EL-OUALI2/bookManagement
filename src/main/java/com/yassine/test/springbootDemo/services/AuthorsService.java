package com.yassine.test.springbootDemo.services;

import com.yassine.test.springbootDemo.entity.Authors;
import com.yassine.test.springbootDemo.errorHandling.AuthorsException;
import com.yassine.test.springbootDemo.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Authors getAuthorById(Long id) {
        return authorsRepository.findById(id)
                .orElseThrow(() -> new AuthorsException("Author Not Found"));
    }
    
    public Authors updateAuthor(Authors author) {
        Authors existingAuthors = authorsRepository.findById(author.getAuthorId()).orElse(null);
        if (existingAuthors != null) {
            existingAuthors.setAuthorName(author.getAuthorName());
            existingAuthors.setBiography(author.getBiography());
            return authorsRepository.save(existingAuthors);
        }
        return null;

    }

    public void deleteAuthor(Authors author) {
        authorsRepository.delete(author);
    }

}
