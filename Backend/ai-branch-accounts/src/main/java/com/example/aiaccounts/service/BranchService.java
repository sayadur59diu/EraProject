package com.example.aiaccounts.service;

import com.example.aiaccounts.dto.BranchOutstandingDTO;
import com.example.aiaccounts.dto.BranchSummaryDTO;
import com.example.aiaccounts.repository.StfETranRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final StfETranRepository tranRepository;

    @Transactional(readOnly = true)
    public List<BranchSummaryDTO> summaryAll() {
        return tranRepository.branchWiseSummaryFromMaster();
    }

    @Transactional(readOnly = true)
    public BranchSummaryDTO summaryFor(String branch) {
        return tranRepository.branchSummaryFor(branch)
                .stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Branch not found: " + branch));
    }

    @Transactional(readOnly = true)
    public List<BranchOutstandingDTO> outstandingAll() {
        return tranRepository.branchWiseOutstanding();
    }

    @Transactional(readOnly = true)
    public BranchOutstandingDTO outstandingFor(String branch) {
        return tranRepository.branchOutstandingFor(branch)
                .stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Branch not found: " + branch));
    }
}
