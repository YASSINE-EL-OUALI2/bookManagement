package com.yassine.test.springbootDemo.repository;

import com.yassine.test.springbootDemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
