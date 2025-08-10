package com.example.saga.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payments")
@Data
public class PaymentEntity {
    @Id

    private String paymentId;

    private String orderId;
    private double amount;
    private String status;
}