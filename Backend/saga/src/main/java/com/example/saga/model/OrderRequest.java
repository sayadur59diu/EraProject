package com.example.saga.model;

import lombok.Data;

@Data
public class OrderRequest {
    private String orderId;
    private boolean paymentSuccess;


    public double getAmount() {
        return 0;
    }

    public int getQuantity() {
        return 0;
    }

    public String getProductId() {
        return null;
    }
}

