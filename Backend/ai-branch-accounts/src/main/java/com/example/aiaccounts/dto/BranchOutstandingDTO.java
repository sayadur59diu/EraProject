package com.example.aiaccounts.dto;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BranchOutstandingDTO {
    private String branchCode;
    private Double outstanding;
}
