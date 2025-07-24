package com.example.eurekaproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication 
@EnableEurekaClient
public class EurekaproductApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaproductApplication.class, args);
	}

}
