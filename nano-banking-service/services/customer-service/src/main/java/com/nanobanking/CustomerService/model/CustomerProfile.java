package com.nanobanking.CustomerService.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "CUSTOMERPROFILE", schema = "CUSTOMER_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerProfile {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(length = 1)
    private String gender;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true, length = 20)
    private String phoneNumber;

    @Column(name = "address_line1", nullable = false, length = 100)
    private String addressLine1;

    @Column(name = "address_line2", length = 100)
    private String addressLine2;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(length = 50)
    private String state;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(name = "account_type", nullable = false, length = 20)
    private String accountType;

    @Column(name = "account_status", length = 20)
    private String accountStatus;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;

    @Column(name = "preferred_language", length = 10)
    private String preferredLanguage;

    @Column(name = "loyalty_program_status", length = 20)
    private String loyaltyProgramStatus;

    @Column(name = "kyc_verified", length = 1)
    private String kycVerified;

    @Lob
    private String notes;
}
