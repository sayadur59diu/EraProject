package com.example.CustomerServiceRedis.service;

import com.example.CustomerServiceRedis.entity.Customer;
import com.example.CustomerServiceRedis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Cacheable(value = "customers", key = "#id")
    public Optional<Customer> getCustomerById(Long id) {
        System.out.println("Fetching from DB for id: " + id);
        return repository.findById(id);
    }

    @CacheEvict(value = "customers", key = "#id")
    public void evictCustomerCache(Long id) {
        System.out.println("Evicting cache for id: " + id);
    }
}
