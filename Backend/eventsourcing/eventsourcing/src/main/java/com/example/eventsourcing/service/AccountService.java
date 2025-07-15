package com.example.eventsourcing.service;

import org.springframework.stereotype.Service;

import com.example.eventsourcing.domain.Account;
import com.example.eventsourcing.event.AccountCreatedEvent;
import com.example.eventsourcing.event.MoneyCreditedEvent;
import com.example.eventsourcing.event.MoneyDebitedEvent;
import com.example.eventsourcing.repository.EventStoreRepository;

@Service

public class AccountService {
    private final EventStoreRepository repository;
    
    public AccountService(EventStoreRepository repository) {
    	this.repository = repository;
    }

    public void handleCreate(String accountId, double balance) {
        var event = new AccountCreatedEvent(accountId, balance);
        repository.save(event);
    }

    public void handleCredit(String accountId, double amount) {
        var event = new MoneyCreditedEvent(accountId, amount);
        repository.save(event);
    }

    public void handleDebit(String accountId, double amount) {
        Account account = rebuildAccount(accountId);
        if (account.getBalance() < amount) throw new RuntimeException("Insufficient funds");
        repository.save(new MoneyDebitedEvent(accountId, amount));
    }

    public Account getAccount(String accountId) {
        return rebuildAccount(accountId);
    }

    private Account rebuildAccount(String accountId) {
        var events = repository.getEventsByAccountId(accountId);
        var account = new Account();
        events.forEach(account::apply);
        return account;
    }
}
