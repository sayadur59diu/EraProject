package com.example.aiaccounts.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "stfetran_test")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class StfETran {
@Id

    @Column(name = "account_no", length = 30, nullable = false)
    private String accountNo;

    @Column(name = "branch_code", length = 10, nullable = false)
    private String branchCode;

    @Column(name = "tran_date", nullable = false)
    private LocalDate tranDate;

    @Column(name = "tran_type", length = 2, nullable = false)
    private String tranType; // 'CR' or 'DR'

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "narrative", length = 4000)
    private String narrative;
}
