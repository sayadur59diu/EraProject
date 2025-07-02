package com.example.SpringEmployeeProfile.exception;

import org.springframework.http.*;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {
        return new ResponseEntity<>("Illegal argument: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Internal error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}