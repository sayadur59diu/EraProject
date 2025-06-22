package com.example.SpringBootKafkaDemoProject.Controller;

import com.example.SpringBootKafkaDemoProject.Service.KafKaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaDemoController {

    @Autowired

    private KafKaProducerService producerService;

    @PostMapping("/publish")

   //This is for single word message
    //public ResponseEntity<String> sendMessage(@RequestParam("msg") String message) {
//This is for string  message
    public ResponseEntity<String> sendMessage(@RequestBody String message) {

        producerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic");
    }
    public String hello() {
        return "Hello World23";
    }
}



