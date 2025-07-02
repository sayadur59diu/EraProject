package com.example.SpringProductDesigner.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ProductDesignerId.class)
@Table(name = "product_type")
public class ProductDesignerEntity {

    @Id
    @Column(name = "branch_code", length = 3, nullable = false)
    @NotNull(message = "Branch code is required!")
    private String branchCode;
    @Id
    @Column(name = "product_type_code", length = 3, nullable = false)
    @NotNull(message = "Product type code is required!")
    private String productTypeCode;

    @Column(name = "short_description", length = 10)
    private String shortDescription;

    @Column(name = "full_description")
    @NotNull(message = "Full description is required!")
    private String fullDescription;

    @Column(name = "account_category", length = 10)
    @NotNull(message = "Account category is required!")
    private String accountCategory;

    @Column(name = "is_Min_Balance_Check_Required", length = 1)
    @NotNull(message = "Minimum balance check requirement is required!")
    private Character isMinBalanceCheckRequired;

    @Column(name = "is_debit_balance_allowed", length = 1)
    @NotNull(message = "Debit balance allowance is required!")
    private Character isDebitBalanceAllowed;

    @Column(name = "is_overdraft_limit_allowed", length = 1)
    @NotNull(message = "Overdraft limit allowance is required!")
    private Character isOverdraftLimitAllowed;

   @Column(name = "is_Passbook_Facilities_Flag", length = 1)
    @NotNull(message = "Passbook facilities availability is required!")
    private Character isPassbookFacilitiesFlag;

    @Column(name = "is_Chequebook_Facilities_Flag", length = 1)
    @NotNull(message = "Cheque book facilities availability is required!")
    private Character isChequebookFacilitiesFlag;

    @Column(name = "cheque_Number_Length", length = 3)
    @NotNull(message = "Cheque number length is required!")
    private Integer chequeNumberLength;

    @Column(name = "cheque_Validity_Month", length = 3)
    @NotNull(message = "Cheque validity month is required!")
    private Integer chequeValidityMonth;

    @Column(name = "interest_Calculation_Method", length = 1)
    @NotNull(message = "Interest calculation method is required!")
    private Character interestCalculationMethod;

    @Column(name = "interest_Debit_Credit_Flag", length = 1)
    @NotNull(message = "Interest debit/credit flag is required!")
    private Character interestDebitCreditFlag;

    @Column(name = "interest_Calculation_Frequency", length = 1)
    @NotNull(message = "Interest calculation frequency is required!")
    private Character interestCalculationFrequency;

    @Column(name = "interest_Rounding_Method", length = 1)
    @NotNull(message = "Interest rounding method is required!")
    private Character interestRoundingMethod;

    @Column(name = "is_Rollover_Allowed", length = 1)
    @NotNull(message = "Rollover allowance is required!")
    private Character isRolloverAllowed;

    @Column(name = "statement_Frequency", length = 1)
    @NotNull(message = "Statement frequency is required!")
    private Character statementFrequency;

    @Column(name = "dormancy_Period", length = 3)
    @NotNull(message = "Dormancy period is required!")
    private String dormancyPeriod;

    @Column(name = "minimum_Deposit_Days", length = 10)
    private Integer minimumDepositDays;

    @Column(name = "maximum_DepositDays", length = 10)
    private Integer maximumDepositDays;

    @Column(name = "has_Maturity_Date", length = 1)
    @NotNull(message = "Has Maturity date requirement is required!")
    private Character hasMaturityDate;

    @Column(name = "last_Interest_Calculation_Date")
    private LocalDate lastInterestCalculationDate;

    @Column(name = "next_Interest_Calculation_Date")
    private LocalDate nextInterestCalculationDate;

    @Column(name = "operation_Id", length = 31)
    @NotNull(message = "Operation ID is required!")
    private String operationId;

    @Column(name = "last_Updated_Timestamp")
    private LocalDateTime lastUpdatedTimestamp;




}
