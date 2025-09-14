package com.cvms.api.dto.response;

import java.time.LocalDate;

import com.cvms.api.entity.candidate.Gender;

public record CandidateResponse(
        String id,
        String name,
        String email,
        LocalDate birthdate,
        Gender gender,
        Double currentSalary) {
}
