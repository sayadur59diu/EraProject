package com.example.saga.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "inventories")
@Data
public class InventoryEntity {
    @Id
    private String inventoryId;

    private String productId;
    private int quantity;
    private String orderId;
    private String status;
}
