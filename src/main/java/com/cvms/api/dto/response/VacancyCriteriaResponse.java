package com.cvms.api.dto.response;

import com.cvms.api.entity.vacancy.CriteriaType;
import com.cvms.api.entity.vacancy.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record VacancyCriteriaResponse(
        CriteriaType type,
        Gender gender,
        Integer minValue,
        Integer maxValue,
        Integer weight) {

}
