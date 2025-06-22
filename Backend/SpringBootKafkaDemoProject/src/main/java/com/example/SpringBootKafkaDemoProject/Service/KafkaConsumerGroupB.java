package com.example.SpringBootKafkaDemoProject.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerGroupB {

    @KafkaListener(topics = "First-topic", groupId = "group_b")
    public void consume(String message) {
        System.out.println("Group B received message: " + message);
    }
}
