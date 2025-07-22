package com.example.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitListeners {

    @RabbitListener(queues = "direct.queue")
    public void listenDirect(String message) {
        System.out.println("Direct queue received: " + message);
    }

    @RabbitListener(queues = "topic.queue")
    public void listenTopic(String message) {
        System.out.println("Topic queue received: " + message);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanout1(String message) {
        System.out.println("Fanout queue1 received: " + message);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanout2(String message) {
        System.out.println("Fanout queue2 received: " + message);
    }
}