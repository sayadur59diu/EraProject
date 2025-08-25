package com.example.aiaccounts.controller;

import com.example.aiaccounts.dto.AccountInfoDTO;
import com.example.aiaccounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/{accountNo}")
    public ResponseEntity<AccountInfoDTO> get(@PathVariable String accountNo) {
        return ResponseEntity.ok(accountService.getAccountInfo(accountNo));
    }
}
