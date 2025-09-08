package com.nanobanking.CustomerService.controller;

import com.nanobanking.CustomerService.dto.ApiResponse;
import com.nanobanking.CustomerService.model.CustomerProfile;
import com.nanobanking.CustomerService.service.CustomerProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService service;

    public CustomerProfileController(CustomerProfileService service) {
        this.service = service;
    }

    // CREATE - Add a new customer
    @PostMapping
    public ResponseEntity<ApiResponse<CustomerProfile>> addCustomer(@RequestBody CustomerProfile customer) {
        if (customer.getAccountStatus() == null) {
            customer.setAccountStatus("Active");
        }
        if (customer.getKycVerified() == null) {
            customer.setKycVerified("N");
        }
        customer.setRegistrationDate(LocalDateTime.now());
        customer.setLastUpdateDate(LocalDateTime.now());

        CustomerProfile saved = service.saveCustomer(customer);

        ApiResponse<CustomerProfile> response = new ApiResponse<>(
                "Customer created successfully",
                LocalDateTime.now(),
                saved
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // READ - Get all customers
    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerProfile>>> getAllCustomers() {
        List<CustomerProfile> customers = service.getAllCustomers();
        ApiResponse<List<CustomerProfile>> response = new ApiResponse<>(
                "Fetched all customers successfully",
                LocalDateTime.now(),
                customers
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // READ - Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerProfile>> getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id)
                .map(customer -> new ResponseEntity<>(
                        new ApiResponse<>("Customer found", LocalDateTime.now(), customer),
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(
                        new ApiResponse<>("Customer not found", LocalDateTime.now(), null),
                        HttpStatus.NOT_FOUND));
    }

    // UPDATE - Update customer by ID
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerProfile>> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerProfile customer) {

        return service.getCustomerById(id)
                .map(existing -> {
                    customer.setCustomerId(id);
                    customer.setLastUpdateDate(LocalDateTime.now());
                    CustomerProfile updated = service.saveCustomer(customer);

                    return new ResponseEntity<>(
                            new ApiResponse<>("Customer updated successfully", LocalDateTime.now(), updated),
                            HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(
                        new ApiResponse<>("Customer not found for update", LocalDateTime.now(), null),
                        HttpStatus.NOT_FOUND));
    }

    // DELETE - Delete customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteCustomer(@PathVariable Long id) {
        return service.getCustomerById(id)
                .map(existing -> {
                    service.deleteCustomer(id);
                    return new ResponseEntity<>(
                            new ApiResponse<>("Customer deleted successfully", LocalDateTime.now(), null),
                            HttpStatus.OK   // ✅ Use OK instead of NO_CONTENT
                    );
                })
                .orElse(new ResponseEntity<>(
                        new ApiResponse<>("Customer not found for deletion", LocalDateTime.now(), null),
                        HttpStatus.NOT_FOUND
                ));
    }
}