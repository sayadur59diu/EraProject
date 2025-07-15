package com.example.eventsourcing.domain;

import com.example.eventsourcing.event.AccountCreatedEvent;
import com.example.eventsourcing.event.MoneyCreditedEvent;
import com.example.eventsourcing.event.MoneyDebitedEvent;

public class Account {
    private String accountId;
    private double balance;

    public Account() {}

    public void apply(AccountEvent event) {
        switch (event.getType()) {
            case "AccountCreated" -> {
                var e = (AccountCreatedEvent) event;
                this.accountId = e.getAccountId();
                this.balance = e.getInitialBalance();
            }
            case "MoneyCredited" -> {
                var e = (MoneyCreditedEvent) event;
                this.balance += e.getAmount();
            }
            case "MoneyDebited" -> {
                var e = (MoneyDebitedEvent) event;
                this.balance -= e.getAmount();
            }
        }
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }
}
