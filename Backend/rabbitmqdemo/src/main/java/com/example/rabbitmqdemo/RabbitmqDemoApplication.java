package com.example.rabbitmqdemo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqDemoApplication implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public RabbitmqDemoApplication(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Sending messages...");

        rabbitTemplate.convertAndSend("direct.exchange", "direct.key", "Hello Direct");
        rabbitTemplate.convertAndSend("topic.exchange", "topic.message", "Hello Topic");
        rabbitTemplate.convertAndSend("fanout.exchange", "", "Hello Fanout");
    }
}