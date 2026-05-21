package com.example.developermon.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DevActivityRequest {
    private String userId;
    private String tool;
    private String project;
    private String state;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
