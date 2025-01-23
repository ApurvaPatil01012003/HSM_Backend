package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") 
public class AuthController {

    @Autowired
    private UserService userService;

    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (!user.getRole().equalsIgnoreCase("ADMIN") && !user.getRole().equalsIgnoreCase("DOCTOR")) {
            return ResponseEntity.badRequest().body("Role must be ADMIN or DOCTOR.");
        }
        return ResponseEntity.ok(userService.register(user));
    }

    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        User user = userService.login(username, password);

        if (user == null) {
            return ResponseEntity.status(401).body("Invalid username or password.");
        }

       
        return ResponseEntity.ok(Map.of(
                "username", user.getUsername(),
                "role", user.getRole()
        ));
    }
}
