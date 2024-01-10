package com.yassine.test.springbootDemo.services;

import com.yassine.test.springbootDemo.entity.Role;
import com.yassine.test.springbootDemo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public List<Role> getRole() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public Role updateRole(Role role) {
        Role existingRole = roleRepository.findById(role.roleid()).orElse(null);
        if (existingRole != null) {
            return roleRepository.save(role);

        }
        return null;
    }

    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }

}
