package com.cvms.api.service.validator;

import org.springframework.stereotype.Component;

import com.cvms.api.dto.request.VacancyCriteriaRequest;
import com.cvms.api.entity.vacancy.CriteriaType;
import com.cvms.api.exception.BadRequestException;

@Component
public class GenderCriteriaValidator implements CriteriaValidator {
    public boolean supports(CriteriaType type) {
        return type.equals(CriteriaType.GENDER);
    }

    public void validate(VacancyCriteriaRequest request) {
        if (request.gender() == null) {
            throw new BadRequestException("Gender criteria must have a gender");
        }
    }
}
