package com.example.SpringBootKafkaStreams.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka-streams")
public class KafkaStreamsController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    public KafkaStreamsController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @PostMapping("/publish")
    public String publishMessage(String message) {
        kafkaTemplate.send("input-topic", message);
        return "Stream:Message sent to Kafka: " + message;
    }

   @GetMapping("/")
    public String hello() {
        return "Hello World23";
    }
}
