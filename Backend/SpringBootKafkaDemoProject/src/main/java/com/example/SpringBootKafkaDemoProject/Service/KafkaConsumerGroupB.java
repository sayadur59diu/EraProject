package com.example.SpringBootKafkaDemoProject.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class KafkaConsumerGroupB {

    private final   List<String> messages = new CopyOnWriteArrayList<>();


    @KafkaListener(topics = "First-topic", groupId = "group_b")
    public void consume(String message) {
        System.out.println("Group B received message: " + message);

        messages.add(message);
    }


   public  List<String> getMessages() {
        return messages;
    }


}
