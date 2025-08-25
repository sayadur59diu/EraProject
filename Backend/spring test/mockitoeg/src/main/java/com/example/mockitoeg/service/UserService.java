package com.example.mockitoeg.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserName(Long userId) {
        // Simulating user fetch logic
        return "User-" + userId;
    }

    public String createUser(String name) {
        // Simulating user creation logic
        return "Created: " + name;
    }
}
