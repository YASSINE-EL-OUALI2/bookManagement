package com.yassine.test.springbootDemo.repository;

import com.yassine.test.springbootDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
