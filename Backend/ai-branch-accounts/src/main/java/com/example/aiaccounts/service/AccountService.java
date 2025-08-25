package com.example.aiaccounts.service;

import com.example.aiaccounts.dto.AccountInfoDTO;
import com.example.aiaccounts.entity.StfAcMas;
import com.example.aiaccounts.repository.StfAcMasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final StfAcMasRepository acMasRepository;

    @Transactional(readOnly = true)
    public AccountInfoDTO getAccountInfo(String accountNo) {
        StfAcMas m = acMasRepository.findById(accountNo)
            .orElseThrow(() -> new IllegalArgumentException("Account not found: " + accountNo));

        Double balance = m.getCurrentBalance();
        if (balance == null) {
            Double out = acMasRepository.computeOutstandingForAccount(accountNo);
            balance = out == null ? 0.0 : -out; // if outstanding positive (DR>CR), balance decreases
        }

        return AccountInfoDTO.builder()
                .accountNo(m.getAccountNo())
                .branchCode(m.getBranchCode())
                .customerName(m.getCustomerName())
                .productCode(m.getProductCode())
                .openDate(m.getOpenDate())
                .status(m.getStatus())
                .currentBalance(balance)
                .build();
    }
}
