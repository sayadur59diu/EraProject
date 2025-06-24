package com.example.SpringBootKafkaDemoProject.Controller;

import com.example.SpringBootKafkaDemoProject.Service.KafKaProducerService;
import com.example.SpringBootKafkaDemoProject.Service.KafkaConsumerGroupB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/kafka")
public class KafkaDemoController {

    @Autowired

    private KafKaProducerService producerService;
    @Autowired
    private KafkaConsumerGroupB consumerGroupB;
    @PostMapping("/publish")

   //This is for single word message
    //public ResponseEntity<String> sendMessage(@RequestParam("msg") String message) {
//This is for string  message
    public ResponseEntity<String> sendMessage(@RequestBody String message) {

        producerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic");
    }

    // 🆕 New GET endpoint to return consumed messages


    @GetMapping("/messages")
    public ResponseEntity<List<String>> getMessages() {

        return ResponseEntity.ok(consumerGroupB.getMessages());
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello World23";
    }
}



