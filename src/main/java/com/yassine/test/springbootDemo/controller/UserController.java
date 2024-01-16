package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.User;
import com.yassine.test.springbootDemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    public List<User> getUsers(){
        System.out.println(userService.getUsers());
        return userService.getUsers();
    }

    // add Item
    @PostMapping("/addUser")
    public void addUser(User user){
        userService.addUser(user);
    }
    // get Item by Id
    @GetMapping("getUserbyid")
    public Optional<User> getUserById(@RequestParam(value = "id") Long id){
        return userService.getUserById(id);
    }
    // update User
    @PostMapping("updateUser")
    public User updateUser(User user){
        return userService.updateUser(user);
    }
    // delete User
    @PostMapping("deleteUser")
    public void deleteUser(User user){
        userService.deleteUser(user);
    }

}
