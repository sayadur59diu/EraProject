package com.example.aiaccounts.repository;

import com.example.aiaccounts.dto.BranchOutstandingDTO;
import com.example.aiaccounts.dto.BranchSummaryDTO;
import com.example.aiaccounts.entity.StfETran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface StfETranRepository extends JpaRepository<StfETran, Long> {

    @Query(value = "SELECT new com.example.aiaccounts.dto.BranchSummaryDTO(m.branchCode, COUNT(m.accountNo), COALESCE(SUM(m.currentBalance), 0.0)) " +
            "FROM com.example.aiaccounts.entity.StfAcMas m GROUP BY m.branchCode")
    List<BranchSummaryDTO> branchWiseSummaryFromMaster();

    @Query(value = "SELECT new com.example.aiaccounts.dto.BranchSummaryDTO(m.branchCode, COUNT(m.accountNo), COALESCE(SUM(m.currentBalance), 0.0)) " +
            "FROM com.example.aiaccounts.entity.StfAcMas m WHERE m.branchCode = :branch GROUP BY m.branchCode")
    List<BranchSummaryDTO> branchSummaryFor(@Param("branch") String branchCode);

    @Query(value = "SELECT new com.example.aiaccounts.dto.BranchOutstandingDTO(t.branchCode, " +
            "SUM(CASE WHEN t.tranType='DR' THEN t.amount ELSE -t.amount END)) " +
            "FROM com.example.aiaccounts.entity.StfETran t GROUP BY t.branchCode")
    List<BranchOutstandingDTO> branchWiseOutstanding();

    @Query(value = "SELECT new com.example.aiaccounts.dto.BranchOutstandingDTO(t.branchCode, " +
            "SUM(CASE WHEN t.tranType='DR' THEN t.amount ELSE -t.amount END)) " +
            "FROM com.example.aiaccounts.entity.StfETran t WHERE t.branchCode = :branch GROUP BY t.branchCode")
    List<BranchOutstandingDTO> branchOutstandingFor(@Param("branch") String branchCode);
}
