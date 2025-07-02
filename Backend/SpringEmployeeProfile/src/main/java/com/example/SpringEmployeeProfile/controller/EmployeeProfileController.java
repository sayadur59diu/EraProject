package com.example.SpringEmployeeProfile.controller;

import com.example.SpringEmployeeProfile.entity.EmployeeProfileEntity;
import com.example.SpringEmployeeProfile.service.EmployeeProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee-profile")
public class EmployeeProfileController {

  @Autowired
    private EmployeeProfileService service;

    @PostMapping
    public ResponseEntity<EmployeeProfileEntity> addEmployee(@Valid @RequestBody EmployeeProfileEntity employee) {


      try {
        EmployeeProfileEntity saved = service.saveEmployee(employee);
        return ResponseEntity.ok(saved);
      } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
      }

//return service.saveEmployee(employee);


    }
}
