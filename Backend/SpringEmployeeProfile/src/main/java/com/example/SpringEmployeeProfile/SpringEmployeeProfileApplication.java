package com.example.SpringEmployeeProfile;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;


@SpringBootApplication
public class SpringEmployeeProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmployeeProfileApplication.class, args);
	}

}