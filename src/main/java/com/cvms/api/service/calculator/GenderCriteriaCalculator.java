package com.cvms.api.service.calculator;

import org.springframework.stereotype.Component;

import com.cvms.api.entity.candidate.Candidate;
import com.cvms.api.entity.vacancy.CriteriaType;
import com.cvms.api.entity.vacancy.Gender;
import com.cvms.api.entity.vacancy.VacancyCriteria;

@Component
public class GenderCriteriaCalculator implements CriteriaCalculator {
    public CriteriaType getType() {
        return CriteriaType.GENDER;
    }

    public Integer calculateScore(Candidate candidate, VacancyCriteria criteria) {

        if (criteria.getGender().equals(Gender.ANY)
                || candidate.getGender().name().equals(criteria.getGender().name())) {
            return criteria.getWeight();
        }

        return 0;
    }
}
