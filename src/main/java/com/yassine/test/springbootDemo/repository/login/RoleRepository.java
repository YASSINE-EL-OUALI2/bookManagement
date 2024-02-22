package com.yassine.test.springbootDemo.repository.login;

import com.yassine.test.springbootDemo.entity.login.ERole;
import com.yassine.test.springbootDemo.entity.login.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByRolename(ERole name);
}
