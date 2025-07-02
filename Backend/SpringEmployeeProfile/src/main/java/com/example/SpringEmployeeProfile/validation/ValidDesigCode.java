package com.example.SpringEmployeeProfile.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DesigCodeValidator.class)
@Documented
public @interface ValidDesigCode {
    String message() default "Designation code does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

