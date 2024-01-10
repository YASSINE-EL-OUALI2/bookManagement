package com.yassine.test.springbootDemo.controller;

import com.yassine.test.springbootDemo.entity.User;
import com.yassine.test.springbootDemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;


    @GetMapping("/getall")
    public List<User> getUser(){
        return userService.getUser();
    }

    // add Item
    @PostMapping("/addUser")
    public void addItem(User user){
        userService.addUser(user);
    }
    // get Item by Id
    @GetMapping("getUserbyid")
    public Optional<User> getUserById(Long id){
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
