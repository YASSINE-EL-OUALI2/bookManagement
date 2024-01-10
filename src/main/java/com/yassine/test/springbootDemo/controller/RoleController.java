package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.Role;
import com.yassine.test.springbootDemo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    RoleService roleService;


    @GetMapping("/getall")
    public List<Role> getRole(){
        return roleService.getRole();
    }

    // add Item
    @PostMapping("/addRole")
    public void addItem(Role role){
        roleService.addRole(role);
    }
    // get Item by Id
    @GetMapping("getRolebyid")
    public Optional<Role> getItemById(Long id){
        return roleService.getRoleById(id);
    }
    // update Role
    @PostMapping("updateRole")
    public Role updateRole(Role role){
        return roleService.updateRole(role);
    }
    // delete Role
    @PostMapping("deleteRole")
    public void deleteRole(Role role){
        roleService.deleteRole(role);
    }

}
