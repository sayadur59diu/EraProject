package com.example.eventsourcing.event;

import com.example.eventsourcing.domain.AccountEvent;

//MoneyDebitedEvent.java
public class MoneyDebitedEvent extends AccountEvent {
 private final double amount;

 public MoneyDebitedEvent(String accountId, double amount) {
     super(accountId);
     this.amount = amount;
 }

 @Override
 public String getType() {
     return "MoneyDebited";
 }

 public double getAmount() {
     return amount;
 }
}

