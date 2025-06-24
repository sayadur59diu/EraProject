package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KafkaProducerService;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducerService producerService;

    /**
     * HTTP GET endpoint to send a message to Kafka.
     * Message will be sent to a partition based on the hash of the message.
     */
    @GetMapping("/send-message")
    public String sendMessage(@RequestParam String message) {
        producerService.sendMessageToPartition(message);  // Send to one of the partitions
        return "Message sent to a partition: " + message;
    }
}
