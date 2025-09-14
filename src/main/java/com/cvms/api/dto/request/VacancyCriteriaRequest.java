package com.cvms.api.dto.request;

import com.cvms.api.entity.vacancy.CriteriaType;
import com.cvms.api.entity.vacancy.Gender;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record VacancyCriteriaRequest(
        @NotNull(message = "Criteria is required") CriteriaType type,
        Integer minValue,
        Integer maxValue,
        Gender gender,

        @Min(value = 1, message = "Weight must be at least 1") Integer weight) {
    public VacancyCriteriaRequest {
        if (weight == null) {
            weight = 1;
        }

    }

}