package com.cvms.api.service.validator;

import com.cvms.api.dto.request.VacancyCriteriaRequest;
import com.cvms.api.entity.vacancy.CriteriaType;

public interface CriteriaValidator {
    boolean supports(CriteriaType type);

    void validate(VacancyCriteriaRequest request);
}
