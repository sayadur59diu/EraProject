package com.example.resilience4j.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ExternalService {

    private final Random random = new Random();

    public String fetchData() {
        if (random.nextInt(10) < 7) { // 70% chance to fail
            throw new RuntimeException("Service failure");
        }
        return "Success from External Service";
    }
}