package com.example.microdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<String> users = new ArrayList<>(); // Simple in-memory storage

    @GetMapping
    public List<String> getUsers() {
        return users;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody String user) {
        users.add(user);
        return ResponseEntity.ok("User added: " + user);
    }
}