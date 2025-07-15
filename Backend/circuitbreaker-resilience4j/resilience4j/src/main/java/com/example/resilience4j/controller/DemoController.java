package com.example.resilience4j.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resilience4j.service.ExternalService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final ExternalService externalService;

    public DemoController(ExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping("/data")
    @CircuitBreaker(name = "externalServiceCB", fallbackMethod = "fallback")
    public String getData() {
    	System.out.println("test fetchdata");
        return externalService.fetchData();
    }

    public String fallback(Throwable t) {
    	System.out.println("test fallback");
        return "Fallback response: External service is down";
    }
}
