package com.example.SpringEmployeeProfile.validation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

@Configuration
public class ValidatorConfig {

    @Bean
    public LocalValidatorFactoryBean validator(ApplicationContext applicationContext) {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        // Using Spring's factory to create the validator
        validator.setConstraintValidatorFactory(new SpringConstraintValidatorFactory(applicationContext.getAutowireCapableBeanFactory()));
        return validator;
    }
}
