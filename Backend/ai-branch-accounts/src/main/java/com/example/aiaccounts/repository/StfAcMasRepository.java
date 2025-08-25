package com.example.aiaccounts.repository;

import com.example.aiaccounts.entity.StfAcMas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface StfAcMasRepository extends JpaRepository<StfAcMas, String> {
    Optional<StfAcMas> findByAccountNo(String accountNo);

    @Query(value = "SELECT SUM(CASE WHEN t.tran_type='DR' THEN t.amount ELSE -t.amount END) " +
                   "FROM stfetran_test t WHERE t.account_no = :accountNo", nativeQuery = true)
    Double computeOutstandingForAccount(@Param("accountNo") String accountNo);
}
