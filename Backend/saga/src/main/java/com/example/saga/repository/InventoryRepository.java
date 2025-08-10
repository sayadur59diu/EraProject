package com.example.saga.repository;

import com.example.saga.entity.InventoryEntity;
import com.example.saga.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryEntity, String> {
}
