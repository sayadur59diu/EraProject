package com.example.SpringBootStarterDemo.service;


import org.springframework.stereotype.Service;

import com.example.SpringBootStarterDemo.model.RetailApplicationRequest;
import com.example.SpringBootStarterDemo.model.RetailApplicationResponse;

@Service
public class RetailAppServiceImpl implements RetailAppService {

    @Override
    public RetailApplicationResponse submitApplication(RetailApplicationRequest request) {
        // Your logic here
        RetailApplicationResponse response = new RetailApplicationResponse();
        response.setStatus("SUCCESS");
        response.setMessage("Application submitted successfully.");
       
        return response;
    }
}