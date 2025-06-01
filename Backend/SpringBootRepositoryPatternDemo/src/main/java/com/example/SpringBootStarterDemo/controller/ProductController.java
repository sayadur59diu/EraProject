package com.example.SpringBootStarterDemo.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStarterDemo.model.Product;
import com.example.SpringBootStarterDemo.service.ProductService;




@RestController
@RequestMapping("/products")

public class ProductController {
	
	@Autowired(required = true)
	private ProductService productService;
	
	//Request URL http://localhost:8080/products/all
		@GetMapping("/all")
		
		
		public Collection<Product> getAllProducts() {
			return productService.getAllProduct();
		}
		
		//Request URL http://localhost:8080/products/1
		@GetMapping("/{id}")
		public Product getProduct(@PathVariable int id) {
			return productService.getProductById(id);
		}
		
		//Request URL http://localhost:8080/products/add
		//Header : Content-Type: application/json
		//Body { "ld":4, "name":"Mobile", "price":7000}
		@PostMapping("/add")   
	   public String addProduct(@RequestBody Product product) {
		   productService.addProduct(product);			
		   return "Product Added Successfull.";
		   
		}
		//This is added by Md. Sayadur Rahaman
		@PutMapping("{id}")
		public String upddateProduct(@PathVariable int id,@RequestBody Product product) {
			productService.updateProduct(id, product); 		
		    return "Product Update Successfull.";
			}		
		//Request URL http://localhost:8080/products/1
		//Header : Content-Type: application/json	
		
		@DeleteMapping("{id}")	
		public String deleteProduct(@PathVariable int id) {
			productService.deleteProduct(id);			
			return "Product Deleted Successfull.";		
		}
		
		
		
}
