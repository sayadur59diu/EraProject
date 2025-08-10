package com.example.CustomerServiceRedis.controller;

import com.example.CustomerServiceRedis.entity.Customer;
import com.example.CustomerServiceRedis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @DeleteMapping("/{id}/cache")
    public String clearCache(@PathVariable Long id) {
        service.evictCustomerCache(id);
        return "Cache cleared for ID: " + id;
    }
}
