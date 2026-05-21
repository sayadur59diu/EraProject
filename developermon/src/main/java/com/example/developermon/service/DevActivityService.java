package com.example.developermon.service;

import com.example.developermon.dto.DevActivityRequest;
import com.example.developermon.entity.DevActivityLog;
import com.example.developermon.repository.DevActivityRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;


@Service
public class DevActivityService {

    private final DevActivityRepository repository;

    public DevActivityService(DevActivityRepository repository) {
        this.repository = repository;
    }

    public void saveActivity(DevActivityRequest req) {
        if(req.getStartTime() == null || req.getEndTime() == null) return;


        long duration = Duration.between(
                req.getStartTime(),
                req.getEndTime()
        ).toMinutes();
        DevActivityLog log = new DevActivityLog();
        log.setUserId(req.getUserId());
        log.setToolName(req.getTool());
        log.setProjectName(req.getProject());
        log.setActivityState(req.getState());
        log.setStartTime(req.getStartTime());
        log.setEndTime(req.getEndTime());
        log.setDurationMin(Math.max(duration, 0));

        repository.save(log);
    }
}
