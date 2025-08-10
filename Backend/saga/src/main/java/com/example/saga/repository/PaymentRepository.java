package com.example.saga.repository;

import com.example.saga.entity.OrderEntity;
import com.example.saga.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, String> {
}
