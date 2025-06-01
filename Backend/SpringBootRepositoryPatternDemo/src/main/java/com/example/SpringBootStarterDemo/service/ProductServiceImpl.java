package com.example.SpringBootStarterDemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.SpringBootStarterDemo.model.Product;
import com.example.SpringBootStarterDemo.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductServiceImpl implements ProductService,ProductRepository{

	private final Map<Integer,Product> productList = new HashMap<>();
	
	    //Populate product list with some sample product
		//@PostMapping
		@PostConstruct
		
		public void init() {
		
			productList.put(1, new Product(1,"Laptop",6000));
			productList.put(2, new Product(2,"Mouch",3000));
			productList.put(3, new Product(3,"Printer",8000));
		}		
	
	@Override
	public List<Product> findAll() {
		
		return new ArrayList<Product>(productList.values());
	}

	@Override
	public Product findById(int id) {
		
		return productList.get(id);
	}

	@Override
	public void save(Product product) {
		productList.put(product.getId(), product);
		
	}
	
  //This is added by Md. Sayadur Rahaman
	@Override
	public void updateById(int id, Product product) {
		productList.put(product.getId(), product);
		
	}

	@Override
	public void deleteById(int id) {
		productList.remove(id);
		
	}

	//Service layer method
	@Override
	public List<Product> getAllProduct() {
		
		return findAll();
	}
	
	

	@Override
	public Product getProductById(int id) {
		return findById(id);
	}

	@Override
	public void addProduct(Product product) {
		save(product);
		
	}

	//This is added by Md. Sayadur Rahaman
	@Override
	public void updateProduct(int id, Product product) {
		updateById(product.getId(), product);
		
	}

	@Override
	public void deleteProduct(int id) {
		deleteById(id);
		
	}

}
