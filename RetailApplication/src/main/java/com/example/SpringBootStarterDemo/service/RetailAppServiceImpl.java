package com.example.SpringBootStarterDemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootStarterDemo.model.RetailApplicationRequest;
import com.example.SpringBootStarterDemo.model.RetailApplicationResponse;
import com.example.SpringBootStarterDemo.repository.RetailAppRepository;

@Service
public class RetailAppServiceImpl implements RetailAppService {

    @Autowired
    private RetailAppRepository retailAppRepository;

    @Override
    public RetailApplicationResponse submitApplication(RetailApplicationRequest request) {
        RetailApplicationResponse response = retailAppRepository.callRetailProcedure(request);

        if (response != null && response.getOutCode() != null && response.getOutCode() == 0) {
            response.setStatus("SUCCESS");
            response.setMessage("Application submitted successfully.");
        } else {
            response.setStatus("FAILURE");
            response.setMessage("Procedure execution failed or returned error code.");
        }

        return response;
    }
}