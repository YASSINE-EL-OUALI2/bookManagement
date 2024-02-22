package com.yassine.test.springbootDemo.controllers.login;

import com.yassine.test.springbootDemo.entity.login.User;
import com.yassine.test.springbootDemo.services.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users/getall")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    // add Item
    @PostMapping("/users/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
    // get Item by Id
    @GetMapping("/users/getUserbyid")
    public Optional<User> getUserById(@RequestParam(value = "id") Long id){
        return userService.getUserById(id);
    }
    // update User
    @PutMapping(value = "/users/updateUser", consumes = "application/json", produces = "application/json")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    // delete User
    @DeleteMapping("/users/deleteUser")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

}