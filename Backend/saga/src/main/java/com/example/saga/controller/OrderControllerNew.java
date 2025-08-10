package com.example.saga.controller;

import com.example.saga.coordinator.SagaOrchestrator;
import com.example.saga.model.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders-new")
@RequiredArgsConstructor
public class OrderControllerNew {

    private final SagaOrchestrator orchestrator;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest request) {
        try {
            orchestrator.startSaga(request);
            return ResponseEntity.ok("Order processed successfully for ID: " + request.getOrderId());
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body("Order failed: " + ex.getMessage());
        }
    }
}