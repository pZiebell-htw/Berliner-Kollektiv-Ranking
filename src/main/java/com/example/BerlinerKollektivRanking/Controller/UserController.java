package com.example.BerlinerKollektivRanking.Controller;

import com.example.BerlinerKollektivRanking.Model.Kollektiv;
import com.example.BerlinerKollektivRanking.Model.User;
import com.example.BerlinerKollektivRanking.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginRequest) {

        User user = userService.findByEmail(loginRequest.getEmail()).orElse(null);
        if (user == null) {
            return ResponseEntity.status(401).build();
        }

        if (!encoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).build();
        }

        user.setPassword(null);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }


}

