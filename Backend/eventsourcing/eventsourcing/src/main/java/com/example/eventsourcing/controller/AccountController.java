package com.example.eventsourcing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventsourcing.domain.Account;
import com.example.eventsourcing.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
    	this.accountService = accountService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestParam String id, @RequestParam double balance) {
        accountService.handleCreate(id, balance);
        return ResponseEntity.ok("Account created");
    }

    @PutMapping("/credit")
    public ResponseEntity<String> credit(@RequestParam String id, @RequestParam double amount) {
        accountService.handleCredit(id, amount);
        return ResponseEntity.ok("Money credited");
    }

    @PutMapping("/debit")
    public ResponseEntity<String> debit(@RequestParam String id, @RequestParam double amount) {
        accountService.handleDebit(id, amount);
        return ResponseEntity.ok("Money debited");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable String id) {
        return ResponseEntity.ok(accountService.getAccount(id));
    }
}

