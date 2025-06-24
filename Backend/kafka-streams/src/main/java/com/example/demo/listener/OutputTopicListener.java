package com.example.demo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OutputTopicListener {

	@KafkaListener(topics = "output-topic", groupId = "debug-group")
    public void listenOutput(String message) {
        System.out.println("Output received: " + message);
    }
}
