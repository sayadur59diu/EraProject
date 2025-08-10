package com.example.saga.coordinator;

import com.example.saga.entity.InventoryEntity;
import com.example.saga.entity.OrderEntity;
import com.example.saga.entity.PaymentEntity;
import com.example.saga.model.OrderRequest;
import com.example.saga.repository.InventoryRepository;
import com.example.saga.repository.OrderRepository;
import com.example.saga.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SagaOrchestrator {

    private final OrderRepository orderRepo;
    private final PaymentRepository paymentRepo;
    private final InventoryRepository inventoryRepo;

    @Transactional
    public void startSaga(OrderRequest request) {
        // Step 1: Save Order
        OrderEntity order = new OrderEntity();
        order.setOrderId(request.getOrderId());
        order.setAmount(request.getAmount());
        order.setStatus("CREATED");
        orderRepo.save(order);

        // Step 2: Save Payment
        if (request.getAmount() > 1000) {
            throw new RuntimeException("Payment rejected - over limit");
        }
        PaymentEntity payment = new PaymentEntity();
        payment.setPaymentId(UUID.randomUUID().toString());
        payment.setOrderId(request.getOrderId());
        payment.setAmount(request.getAmount());
        payment.setStatus("PAID");
        paymentRepo.save(payment);


        // Step 3: Save Inventory
        if (request.getQuantity() > 10) {
            throw new RuntimeException("Inventory unavailable");
        }
        InventoryEntity inventory = new InventoryEntity();
        inventory.setInventoryId(UUID.randomUUID().toString());
        inventory.setProductId(request.getProductId());
        inventory.setQuantity(request.getQuantity());
        inventory.setOrderId(request.getOrderId());
        inventory.setStatus("RESERVED");
        inventoryRepo.save(inventory);

        // All steps successful
        order.setStatus("COMPLETED");
        orderRepo.save(order);
    }
}
