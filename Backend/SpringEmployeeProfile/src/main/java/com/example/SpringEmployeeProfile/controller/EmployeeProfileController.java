package com.example.SpringEmployeeProfile.controller;

import com.example.SpringEmployeeProfile.entity.EmployeeProfileEntity;
import com.example.SpringEmployeeProfile.service.EmployeeProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public EmployeeProfileEntity addEmployee(@Valid @RequestBody EmployeeProfileEntity employee) {
      //EmployeeProfileEntity saved = service.saveEmployee(employee);
      return service.saveEmployee(employee);


      //return (EmployeeProfileEntity) ResponseEntity.ok( saved);
    }
}
