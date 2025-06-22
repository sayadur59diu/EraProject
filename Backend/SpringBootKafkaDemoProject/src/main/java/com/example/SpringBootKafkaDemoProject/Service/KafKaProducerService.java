package com.example.SpringBootKafkaDemoProject.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafKaProducerService {

    private static final String TOPIC = "First-topic";
    @Autowired

    private KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Message sent to Kafka topic: " + TOPIC + " Message: " + message);
    }

}
