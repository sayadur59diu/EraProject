package com.example.rabbitmqdemo;
import com.example.rabbitmqdemo.model.StatementRequest;
import com.example.rabbitmqdemo.service.StatementProducer;
import org.springframework.amqp.core.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SpringBootRabbitmqDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmqDemo.class, args);
    }



    /*public class TestRunner {
        @Bean
        public CommandLineRunner sendTestRequest(StatementProducer producer) {
            return args -> {
                StatementRequest req = new StatementRequest();
                req.setActype("S04");
                req.setBrancd("107");
                producer.requestStatement(req);
            };
        }
    }*/
}