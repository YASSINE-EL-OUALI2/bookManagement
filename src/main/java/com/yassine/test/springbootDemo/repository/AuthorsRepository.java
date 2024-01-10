package com.yassine.test.springbootDemo.repository;

import com.yassine.test.springbootDemo.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {
}
