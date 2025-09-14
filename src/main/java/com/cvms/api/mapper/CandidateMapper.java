package com.cvms.api.mapper;

import org.springframework.stereotype.Component;

import com.cvms.api.dto.request.CandidateCreateRequest;
import com.cvms.api.dto.request.CandidateUpdateRequest;
import com.cvms.api.dto.response.CandidateResponse;
import com.cvms.api.entity.candidate.Candidate;

@Component
public class CandidateMapper {

    public Candidate toEntity(CandidateCreateRequest dto) {
        return Candidate.builder()
                .name(dto.name())
                .email(dto.email())
                .birthdate(dto.birthdate())
                .gender(dto.gender())
                .currentSalary(dto.currentSalary())
                .build();
    }

    public Candidate updateEntity(Candidate entity, CandidateUpdateRequest dto) {
        entity.setName(dto.name());
        entity.setEmail(dto.email());
        entity.setBirthdate(dto.birthdate());
        entity.setGender(dto.gender());
        entity.setCurrentSalary(dto.currentSalary());
        return entity;
    }

    public CandidateResponse toResponse(Candidate entity) {
        return new CandidateResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getBirthdate(),
                entity.getGender(),
                entity.getCurrentSalary());
    }
}
