package com.yassine.test.springbootDemo.controllers.login;

import com.yassine.test.springbootDemo.entity.login.User;
import com.yassine.test.springbootDemo.services.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    // add Item
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
    // get Item by Id
    @GetMapping("/getUserbyid")
    public Optional<User> getUserById(@RequestParam(value = "id") Long id){
        return userService.getUserById(id);
    }
    // update User
    @PutMapping(value = "/updateUser", consumes = "application/json", produces = "application/json")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    // delete User
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

}
