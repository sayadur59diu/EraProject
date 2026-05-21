package com.example.developermon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "DEV_ACTIVITY_LOG")
@Getter
@Setter
public class DevActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "TOOL_NAME")
    private String toolName;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "ACTIVITY_STATE")
    private String activityState;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @Column(name = "END_TIME")
    private LocalDateTime endTime;

    @Column(name = "DURATION_MIN")
    private Long durationMin;
}