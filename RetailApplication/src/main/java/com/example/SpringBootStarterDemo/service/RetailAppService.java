package com.example.SpringBootStarterDemo.service;



import com.example.SpringBootStarterDemo.model.RetailApplicationRequest;
import com.example.SpringBootStarterDemo.model.RetailApplicationResponse;


public interface RetailAppService {
	
	RetailApplicationResponse submitApplication(RetailApplicationRequest request);
}
