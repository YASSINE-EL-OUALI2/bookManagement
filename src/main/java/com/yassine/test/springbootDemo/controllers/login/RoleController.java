package com.yassine.test.springbootDemo.controllers.login;

import com.yassine.test.springbootDemo.entity.login.Role;
import com.yassine.test.springbootDemo.services.login.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    RoleService roleService;


    @GetMapping("/role/getall")
    public List<Role> getRole(){
        return roleService.getRole();
    }

    // add Item
    @PostMapping("/role/addRole")
    public void addRole(@RequestBody Role role){
        roleService.addRole(role);
    }
    // get Item by Id
    @GetMapping("/role/getRolebyid")
    public Optional<Role> getItemById(@RequestParam(value = "id") Long id){
        return roleService.getRoleById(id);
    }
    // update Role
    @PutMapping(value = "/role/updateRole", consumes = "application/json", produces = "application/json")
    public Role updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }
    // delete Role
    @DeleteMapping("/role/deleteRole")
    public void deleteRole(@RequestBody Role role){
        roleService.deleteRole(role);
    }

}
