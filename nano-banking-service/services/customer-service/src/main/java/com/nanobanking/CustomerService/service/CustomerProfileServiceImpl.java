package com.nanobanking.CustomerService.service;

import com.nanobanking.CustomerService.model.CustomerProfile;
import com.nanobanking.CustomerService.repository.CustomerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repository;

    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerProfile saveCustomer(CustomerProfile customer) {
        return repository.save(customer);
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Optional<CustomerProfile> getCustomerById(Long customerId) {
        return repository.findById(customerId);
    }

    @Override
    public Optional<CustomerProfile> getCustomerByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        repository.deleteById(customerId);
    }
}
