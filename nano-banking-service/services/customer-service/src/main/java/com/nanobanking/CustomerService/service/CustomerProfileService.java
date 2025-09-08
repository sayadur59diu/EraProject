package com.nanobanking.CustomerService.service;
import com.nanobanking.CustomerService.model.CustomerProfile;

import java.util.List;
import java.util.Optional;

public interface CustomerProfileService {

    CustomerProfile saveCustomer(CustomerProfile customer);

    List<CustomerProfile> getAllCustomers();

    Optional<CustomerProfile> getCustomerById(Long customerId);

    Optional<CustomerProfile> getCustomerByEmail(String email);

    void deleteCustomer(Long customerId);
}
