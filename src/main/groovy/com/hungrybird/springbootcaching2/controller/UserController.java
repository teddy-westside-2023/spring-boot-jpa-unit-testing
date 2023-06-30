package com.hungrybird.springbootcaching2.controller;

import com.hungrybird.springbootcaching2.entity.User;
import com.hungrybird.springbootcaching2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v0/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PutMapping
    public ResponseEntity<?> env() {
        Map<String, String> env = System.getenv();
        return ResponseEntity.ok(env);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<User> users = (List<User>) this.userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/findByUsername")
    public ResponseEntity<?> findByUsername(@RequestParam String username) {
        List<User> users = this.userRepository.findByUsername(username);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/findAllByUsernameAndAirport")
    public ResponseEntity<?> findAllByUsernameAndAirport(@RequestParam String username, @RequestParam String airport) {
        List<User> users = this.userRepository.findAllByUsernameAndAirport(username, airport);
        return ResponseEntity.ok(users);
    }
}
