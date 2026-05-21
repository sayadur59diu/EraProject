package com.example.developermon.repository;

import com.example.developermon.entity.DevActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DevActivityRepository extends JpaRepository<DevActivityLog, Long> {

        @Query("SELECT d FROM DevActivityLog d WHERE d.userId = :userId AND d.startTime BETWEEN :start AND :end")
        List<DevActivityLog> findByUserAndDateRange(@Param("userId") String userId,
                                                    @Param("start") LocalDate start,
                                                    @Param("end") LocalDate end);
}
