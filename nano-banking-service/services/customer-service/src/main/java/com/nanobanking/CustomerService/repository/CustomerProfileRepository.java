package com.nanobanking.CustomerService.repository;

import com.nanobanking.CustomerService.model.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {

    Optional<CustomerProfile> findByEmail(String email);

    Optional<CustomerProfile> findByPhoneNumber(String phoneNumber);
}
