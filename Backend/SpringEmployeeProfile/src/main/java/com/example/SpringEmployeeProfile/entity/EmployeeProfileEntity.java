package com.example.SpringEmployeeProfile.entity;


import com.example.SpringEmployeeProfile.validation.ValidDesigCode;
import jakarta.persistence.*;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.NotFound;

import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hrm_personal_info")
public class EmployeeProfileEntity {

    @Id
    @Column(name = "emp_id", length = 10)
    @Size(max = 10, message = "Employee ID must not exceed 10 characters")
    private String empId;

    @Column(name = "emp_name", length = 200)
    @Size(max = 200, message = "Employee name must not exceed 200 characters")
    @NotBlank(message = "Employee name is required")
    private String empName;

    @Column(name = "dob")
    @Past(message = "Date of birth must be in the past")
    @NotNull(message = "DOB is required")
    private LocalDate dob;

    @Column(name = "salary")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal salary;

    @Lob
    @Column(name = "photo")
    private Blob photo;

    @Column(name = "inserted_by", length = 31)
    private String insertedBy;

    @Column(name = "inserted_date")
    private LocalDateTime insertedDate;

    @Column(name = "desig_code", length = 3)
    @Size(max = 3, message = "Designation code must not exceed 3 characters")
    @NotBlank(message = "Designation code is required")
    @ValidDesigCode
    private String desigCode;

    @Column(name = "status", length = 1)
    @Size(max = 1, message = "Status must be a single character")
    @Pattern(regexp = "^[AI]$", message = "Status must be 'A' for Active or 'I' for Inactive")
    @NotBlank(message = "Status is required")
    private String status;

    // Automatically validate DOB age on persist
    @PrePersist
    public void validateBeforeInsert() {
        if (dob != null && Period.between(dob, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Employee must be at least 18 years old.");
        }

        // Fill insertedDate if not already set
        if (insertedDate == null) {
            insertedDate = LocalDateTime.now();
        }
    }


}