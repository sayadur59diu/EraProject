package com.example.aiaccounts.controller;

import com.example.aiaccounts.dto.BranchOutstandingDTO;
import com.example.aiaccounts.dto.BranchSummaryDTO;
import com.example.aiaccounts.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @GetMapping("/summary")
    public ResponseEntity<List<BranchSummaryDTO>> summaryAll() {
        return ResponseEntity.ok(branchService.summaryAll());
    }

    @GetMapping("/{branchCode}/summary")
    public ResponseEntity<BranchSummaryDTO> summaryOne(@PathVariable String branchCode) {
        return ResponseEntity.ok(branchService.summaryFor(branchCode));
    }

    @GetMapping("/outstanding")
    public ResponseEntity<List<BranchOutstandingDTO>> outstandingAll() {
        return ResponseEntity.ok(branchService.outstandingAll());
    }

    @GetMapping("/{branchCode}/outstanding")
    public ResponseEntity<BranchOutstandingDTO> outstandingOne(@PathVariable String branchCode) {
        return ResponseEntity.ok(branchService.outstandingFor(branchCode));
    }
}
