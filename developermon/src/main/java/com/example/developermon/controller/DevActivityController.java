package com.example.developermon.controller;

import com.example.developermon.dto.DevActivityRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.developermon.service.DevActivityService;

@RestController
@RequestMapping("/api/dev-activity")
public class DevActivityController {


    private final DevActivityService service;


    public DevActivityController(DevActivityService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<String> logActivity(@RequestBody DevActivityRequest request) {
        service.saveActivity(request);
        return ResponseEntity.ok("Activity logged successfully");
    }
}
