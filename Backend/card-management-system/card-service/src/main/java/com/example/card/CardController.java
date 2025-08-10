package com.example.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/issue")
    public String issueCard() {
        try {
            String fraudStatus = restTemplate.getForObject("http://fraud-service/fraud/check", String.class);
            if (!"clear".equalsIgnoreCase(fraudStatus)) {
                return "❌ Fraud detected. Card not issued.";
            }
        } catch (Exception e) {
            return "❌ Fraud service is unavailable. Please try again later.";
        }

        String pin;
        try {
            pin = restTemplate.getForObject("http://pin-service/pin/generate", String.class);
        } catch (Exception e) {
            return "❌ PIN service is unavailable. Cannot issue card.";
        }

        try {
            restTemplate.getForObject("http://notification-service/notify/success", String.class);
        } catch (Exception e) {
            // Notification is optional – we continue
        }

        return "✅ Card issued with PIN: " + pin;
    }
}