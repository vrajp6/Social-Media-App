package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// provides an API endpoint for registering a new user. returns the user object that was saved to the database

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        User registeredUser = userService.registerNewUser(user);
        return ResponseEntity.ok(registeredUser);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
    boolean isAuthenticated = userService.authenticateUser(loginUser.getUsername(), loginUser.getPassword());
    if (isAuthenticated) {
        // Generate and return a token (e.g., JWT)
        // For now, returning a simple success message
        return ResponseEntity.ok("User authenticated successfully");
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
}
