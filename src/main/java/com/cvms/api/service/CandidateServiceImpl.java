package com.cvms.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cvms.api.dto.request.CandidateCreateRequest;
import com.cvms.api.dto.request.CandidateUpdateRequest;
import com.cvms.api.dto.response.CandidateResponse;
import com.cvms.api.entity.candidate.Candidate;
import com.cvms.api.exception.NotFoundException;
import com.cvms.api.exception.BadRequestException;
import com.cvms.api.mapper.CandidateMapper;
import com.cvms.api.repository.CandidateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper;

    public CandidateResponse createCandidate(CandidateCreateRequest request) {
        if (candidateRepository.existsByEmail(request.email())) {
            throw new BadRequestException("Email already exists");
        }

        Candidate candidate = candidateMapper.toEntity(request);

        return candidateMapper.toResponse(candidateRepository.save(candidate));
    }

    public Page<CandidateResponse> getAllCandidates(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return candidateRepository.findAll(pageable).map(candidateMapper::toResponse);
    }

    public CandidateResponse updateCandidate(String id, CandidateUpdateRequest request) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Candidate not found"));

        if (candidateRepository.existsByEmailAndIdNot(request.email(), id)) {
            throw new BadRequestException("Email already exists");
        }

        Candidate updatedCandidate = candidateMapper.updateEntity(candidate, request);

        return candidateMapper.toResponse(candidateRepository.save(updatedCandidate));

    }

    public void deleteCandidate(String id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Candidate not found"));

        candidateRepository.delete(candidate);
    }
}
