package com.cvms.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cvms.api.dto.request.CandidateCreateRequest;
import com.cvms.api.dto.request.CandidateUpdateRequest;
import com.cvms.api.dto.response.ApiPaginateResponse;
import com.cvms.api.dto.response.ApiResponse;
import com.cvms.api.dto.response.CandidateResponse;
import com.cvms.api.service.CandidateService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController()
@RequestMapping("/api/candidates")
@AllArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping("")
    public ResponseEntity<ApiResponse<CandidateResponse>> createCandidate(
            @Valid @RequestBody CandidateCreateRequest request) {
        CandidateResponse candidate = candidateService.createCandidate(request);
        return ResponseEntity.ok(ApiResponse.ok(candidate));
    }

    @GetMapping("")
    public ResponseEntity<ApiPaginateResponse<CandidateResponse>> getAllCandidate(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<CandidateResponse> candidates = candidateService.getAllCandidates(page, size);

        return ResponseEntity.ok(ApiPaginateResponse.of(candidates.getContent(), candidates.getTotalElements(),
                candidates.getTotalPages(), page, size));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CandidateResponse>> updateCandidate(@PathVariable String id,
            @Valid @RequestBody CandidateUpdateRequest request) {
        CandidateResponse candidate = candidateService.updateCandidate(id, request);

        return ResponseEntity.ok(ApiResponse.ok(candidate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable String id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.noContent().build();
    }
}
