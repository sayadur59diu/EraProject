package com.example.pin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pin")
public class PinController {

  @GetMapping("/generate")
  public String generatePin() {
    return String.valueOf((int)(1000 + Math.random() * 9000));
  }
}