package com.example.rabbitmqdemo.service;

import com.example.rabbitmqdemo.model.StatementRequest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class StatementProducer {

    private final RabbitTemplate rabbitTemplate;

    public StatementProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void requestStatement(StatementRequest request) {
        rabbitTemplate.convertAndSend("statement.exchange", "statement.generate", request);
    }
}
