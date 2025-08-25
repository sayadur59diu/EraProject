package com.example.aiaccounts.dto;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BranchSummaryDTO {
    private String branchCode;
    private Long accountCount;
    private Double totalBalance;
}
