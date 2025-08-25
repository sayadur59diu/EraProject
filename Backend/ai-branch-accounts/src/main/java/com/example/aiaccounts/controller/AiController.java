package com.example.aiaccounts.controller;
import com.example.aiaccounts.ai.AiSqlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AiController {

    private final AiSqlService aiSqlService;

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody AiQuery query) {
        System.out.println("Received question: " + query.question());
        try {
            String result = aiSqlService.answer(query.question());
            return Map.of("result", result);
        } catch (Exception ex) {
            return Map.of("error", ex.getMessage());
        }
    }
}