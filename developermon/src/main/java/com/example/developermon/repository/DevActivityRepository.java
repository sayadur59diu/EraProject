package com.example.developermon.repository;

import com.example.developermon.entity.DevActivityLog;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface DevActivityRepository
        extends JpaRepository<DevActivityLog, Long> {
}