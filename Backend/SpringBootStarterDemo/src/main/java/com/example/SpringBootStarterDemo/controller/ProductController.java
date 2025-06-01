package com.example.SpringBootStarterDemo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStarterDemo.model.Product;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/products")

public class ProductController {
	
	private Map<Integer, Product> productList= new HashMap<>();
	
	//Populate product list with some sample product
	//@PostMapping
	@PostConstruct
	
	public void init() {
	
		productList.put(1, new Product(1,"Laptop",6000));
		productList.put(2, new Product(2,"Mouch",3000));
		productList.put(3, new Product(3,"Printer",8000));
	}
	//Request URL http://localhost:8080/products/
	@GetMapping("/")
	public String hello() {
		return "Product Management Model";
	}
	
	//Request URL http://localhost:8080/products/all
	@GetMapping("/all")
	public Collection<Product> getAllProducts() {
		return productList.values();
	}
	//Request URL http://localhost:8080/products/1
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		return productList.get(id);
	}
   
	//Request URL http://localhost:8080/products/add
	//Header : Content-Type: application/json
	//Body { "ld":4, "name":"Mobile", "price":7000}
	@PostMapping("/add")   
   public String addProduct(@RequestBody Product product) {
	   productList.put(product.getId(), product);
	   return "Product Added Successfull.";
	   
	}
	
	//Request URL http://localhost:8080/products/1
	//Header : Content-Type: application/json
	//Body { "ld":1, "name":"Monitor", "price":9000}
		
	@PutMapping("{id}")
	public String upddateProduct(@PathVariable int id,@RequestBody Product product) {
		 productList.put(id, product);
		 return "Product Update Successfull.";
		}
	
	
	//Request URL http://localhost:8080/products/1
	//Header : Content-Type: application/json	
	
	@DeleteMapping("{id}")	
	public String deleteProduct(@PathVariable int id) {
		productList.remove(id);
		return "Product Deleted Successfull.";		
	}
	
}
