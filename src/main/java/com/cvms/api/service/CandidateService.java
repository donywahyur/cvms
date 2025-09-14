package com.cvms.api.service;

import org.springframework.data.domain.Page;

import com.cvms.api.dto.request.CandidateCreateRequest;
import com.cvms.api.dto.request.CandidateUpdateRequest;
import com.cvms.api.dto.response.CandidateResponse;

public interface CandidateService {
    CandidateResponse createCandidate(CandidateCreateRequest request);

    Page<CandidateResponse> getAllCandidates(Integer page, Integer size);

    CandidateResponse updateCandidate(String id, CandidateUpdateRequest candidate);

    void deleteCandidate(String id);
}
