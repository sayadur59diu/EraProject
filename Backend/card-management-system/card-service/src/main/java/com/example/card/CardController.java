package com.example.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/card")
public class CardController {

  @Autowired
  @LoadBalanced
  private RestTemplate restTemplate;

  @GetMapping("/issue")
  public String issueCard() {
    String fraudStatus = restTemplate.getForObject("http://fraud-service/fraud/check", String.class);
    if (!"clear".equals(fraudStatus)) {
      return "Fraud detected, card not issued.";
    }
    String pin = restTemplate.getForObject("http://pin-service/pin/generate", String.class);
    restTemplate.getForObject("http://notification-service/notify/success", String.class);
    return "Card issued with PIN: " + pin;
  }
}