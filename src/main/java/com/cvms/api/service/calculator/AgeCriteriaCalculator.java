package com.cvms.api.service.calculator;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

import com.cvms.api.entity.candidate.Candidate;
import com.cvms.api.entity.vacancy.CriteriaType;
import com.cvms.api.entity.vacancy.VacancyCriteria;

@Component
public class AgeCriteriaCalculator implements CriteriaCalculator {
    public CriteriaType getType() {
        return CriteriaType.AGE;
    }

    public Integer calculateScore(Candidate candidate, VacancyCriteria criteria) {

        int candidateAge = Period.between(candidate.getBirthdate(), LocalDate.now()).getYears();

        if (candidateAge >= criteria.getMinValue() && candidateAge <= criteria.getMaxValue())
            return criteria.getWeight();

        return 0;
    }
}
