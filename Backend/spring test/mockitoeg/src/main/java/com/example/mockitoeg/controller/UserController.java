package com.example.mockitoeg.controller;

import com.example.mockitoeg.model.UserRequest;
import com.example.mockitoeg.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return userService.getUserName(id);
    }

    @PostMapping
    public String createUser(@RequestBody UserRequest request) {
        return userService.createUser(request.getName());
    }
}
