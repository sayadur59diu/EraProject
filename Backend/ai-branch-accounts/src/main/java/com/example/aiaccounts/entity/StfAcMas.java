package com.example.aiaccounts.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "stfacmas_test")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class StfAcMas {
@Id
    @Column(name = "account_no", length = 30)
    private String accountNo;

    @Column(name = "branch_code", length = 10, nullable = false)
    private String branchCode;

    @Column(name = "customer_name", length = 200)
    private String customerName;

    @Column(name = "product_code", length = 50)
    private String productCode;

    @Column(name = "open_date")
    private LocalDate openDate;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "current_balance")
    private Double currentBalance;
}
