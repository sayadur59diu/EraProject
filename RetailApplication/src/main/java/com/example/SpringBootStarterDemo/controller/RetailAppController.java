package com.example.SpringBootStarterDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStarterDemo.model.RetailApplicationRequest;
import com.example.SpringBootStarterDemo.model.RetailApplicationResponse;
import com.example.SpringBootStarterDemo.service.RetailAppService;



@RestController
@RequestMapping("api/appgen")

public class RetailAppController {

    @Autowired
    private RetailAppService retailAppService;

    @PostMapping("/submit")
    public ResponseEntity<RetailApplicationResponse> submitApplication(@RequestBody RetailApplicationRequest request) {
        RetailApplicationResponse response = retailAppService.submitApplication(request);
        return ResponseEntity.ok(response);
    }
}
