package com.example.SpringBootKafkaDemoProject.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service


public class KafkaConsumerGroupA {

     @KafkaListener (topics = "First-topic", groupId = "group_a")
    public void consume(String message) {
        System.out.println("Group A received message: " + message);
     }
}
