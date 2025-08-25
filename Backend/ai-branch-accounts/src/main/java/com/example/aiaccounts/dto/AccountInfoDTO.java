package com.example.aiaccounts.dto;

import lombok.*;
import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class AccountInfoDTO {
    private String accountNo;
    private String branchCode;
    private String customerName;
    private String productCode;
    private LocalDate openDate;
    private String status;
    private Double currentBalance;
}
