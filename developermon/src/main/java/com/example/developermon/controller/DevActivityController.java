package com.example.developermon.controller;

        import com.example.developermon.dto.DevActivityRequest;
        import com.example.developermon.service.DevActivityService;
        import org.springframework.http.ResponseEntity;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/dev-activity")
@Validated
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

