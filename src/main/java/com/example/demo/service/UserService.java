package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user); // Save user to database
    }

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password); // Find user by username and password
    }
}
