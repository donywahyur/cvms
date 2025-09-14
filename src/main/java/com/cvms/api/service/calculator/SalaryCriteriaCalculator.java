package com.cvms.api.service.calculator;

import org.springframework.stereotype.Component;

import com.cvms.api.entity.candidate.Candidate;
import com.cvms.api.entity.vacancy.CriteriaType;
import com.cvms.api.entity.vacancy.VacancyCriteria;

@Component
public class SalaryCriteriaCalculator implements CriteriaCalculator {
    public Integer calculateScore(Candidate candidate, VacancyCriteria criteria) {
        if (criteria.getType() != CriteriaType.SALARY)
            return 0;

        if (candidate.getCurrentSalary() >= criteria.getMinValue()
                && candidate.getCurrentSalary() <= criteria.getMaxValue())
            return criteria.getWeight();

        return 0;
    }
}
