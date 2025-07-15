package com.example.eventsourcing.event;

import com.example.eventsourcing.domain.AccountEvent;

//AccountCreatedEvent.java
public class AccountCreatedEvent extends AccountEvent {
 private final double initialBalance;

 public AccountCreatedEvent(String accountId, double initialBalance) {
     super(accountId);
     this.initialBalance = initialBalance;
 }

 @Override
 public String getType() {
     return "AccountCreated";
 }

 public double getInitialBalance() {
     return initialBalance;
 }
}
