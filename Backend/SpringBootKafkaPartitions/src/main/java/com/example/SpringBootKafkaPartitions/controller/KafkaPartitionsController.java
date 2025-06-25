package com.example.SpringBootKafkaPartitions.controller;

import com.example.SpringBootKafkaPartitions.services.KafkaPartitionsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class KafkaPartitionsController {
    @Autowired
    private KafkaPartitionsProducer  kafkaPartitionsProducer;

    @PostMapping("/send-messages")
    public String sendMessages(@RequestParam String message) {

            kafkaPartitionsProducer.sendMessageToPartition(message);

        return "Messages sent to Kafka partitions!"+message;
    }

     @GetMapping("/")
    public String hello() {
         return "Welcome to the Kafka Partitions API!";
     }
}
