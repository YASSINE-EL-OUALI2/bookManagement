package com.yassine.test.springbootDemo.services;

import com.yassine.test.springbootDemo.entity.User;
import com.yassine.test.springbootDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getUserid()).orElse(null);
        if (existingUser != null) {
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}
