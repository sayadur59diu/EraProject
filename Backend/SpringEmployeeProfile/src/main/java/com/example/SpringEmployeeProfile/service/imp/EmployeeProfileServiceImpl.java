package com.example.SpringEmployeeProfile.service.imp;

import com.example.SpringEmployeeProfile.entity.EmployeeProfileEntity;
import com.example.SpringEmployeeProfile.repository.EmployeeProfileRepository;
import com.example.SpringEmployeeProfile.service.EmployeeProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    @Autowired
    private EmployeeProfileRepository repository;
    @Override
    public EmployeeProfileEntity saveEmployee(EmployeeProfileEntity employee) {
        // Validate empId length and numeric
        if (employee.getEmpId() == null || employee.getEmpId().length() != 10 || !employee.getEmpId().matches("\\d{10}")) {
            throw new IllegalArgumentException("Employee ID must be a 10-digit numeric string");
        }

// Check duplicate
        if (repository.existsByEmpId(employee.getEmpId())) {
            throw new IllegalArgumentException("Employee ID already exists");
        }

        return repository.save(employee);
    }

}

