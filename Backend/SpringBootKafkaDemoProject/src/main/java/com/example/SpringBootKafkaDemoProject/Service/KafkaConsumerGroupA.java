package com.example.SpringBootKafkaDemoProject.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service


public class KafkaConsumerGroupA {
    // This class can be used to implement consumer logic for Group A
    // For example, you can use @KafkaListener to listen to messages from a specific topic
    // and process them accordingly.

    // Example:
     @KafkaListener (topics = "First-topic", groupId = "group_a")
    public void consume(String message) {
        System.out.println("Group A received message: " + message);
     }
}
