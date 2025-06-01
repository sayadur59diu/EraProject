package com.example.SpringBootStarterDemo.service;

import java.util.List;



import com.example.SpringBootStarterDemo.model.Product;

public interface ProductService {

	List<Product> getAllProduct();
	Product getProductById(int id);
	void addProduct(Product product);
	//This is added by Md. Sayadur Rahaman
	void updateProduct(int id,Product product);
	void deleteProduct(int id);

	
}
