package com.example.SpringEmployeeProfile.repository;



import com.example.SpringEmployeeProfile.entity.EmployeeProfileEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfileEntity, String> {
    boolean existsByEmpId(String empId);
}
