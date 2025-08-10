package com.example.CustomerServiceRedis;

import com.example.CustomerServiceRedis.entity.Customer;
import com.example.CustomerServiceRedis.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CustomerServiceRedisApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;



	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceRedisApplication.class, args);
	}
	@Override
	public void run(String... args) {
		// Seed DB
		repository.save(new Customer(1L, "Alice", "alice@example.com"));
		repository.save(new Customer(2L, "Bob", "bob@example.com"));
	}
}