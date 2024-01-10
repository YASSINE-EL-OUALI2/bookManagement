package com.yassine.test.springbootDemo.repository;

import com.yassine.test.springbootDemo.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
}
