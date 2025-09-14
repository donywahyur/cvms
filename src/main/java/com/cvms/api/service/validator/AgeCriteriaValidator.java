package com.cvms.api.service.validator;

import org.springframework.stereotype.Component;

import com.cvms.api.dto.request.VacancyCriteriaRequest;
import com.cvms.api.entity.vacancy.CriteriaType;
import com.cvms.api.exception.BadRequestException;

@Component
public class AgeCriteriaValidator implements CriteriaValidator {
    public boolean supports(CriteriaType type) {
        return type.equals(CriteriaType.AGE);
    }

    public void validate(VacancyCriteriaRequest request) {
        if (request.minValue() == null || request.maxValue() == null) {
            throw new BadRequestException("Age criteria must have min and max values");
        }
    }
}
