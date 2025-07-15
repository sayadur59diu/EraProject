package com.example.eventsourcing.event;

import com.example.eventsourcing.domain.AccountEvent;

//MoneyCreditedEvent.java
public class MoneyCreditedEvent extends AccountEvent {
 private final double amount;

 public MoneyCreditedEvent(String accountId, double amount) {
     super(accountId);
     this.amount = amount;
 }

 @Override
 public String getType() {
     return "MoneyCredited";
 }

 public double getAmount() {
     return amount;
 }
}

