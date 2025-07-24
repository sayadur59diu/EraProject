package com.example.fraud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FraudServiceApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(FraudServiceApplication.class, args);
    }
}
