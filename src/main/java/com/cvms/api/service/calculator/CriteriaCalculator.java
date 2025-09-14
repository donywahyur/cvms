package com.cvms.api.service.calculator;

import com.cvms.api.entity.candidate.Candidate;
import com.cvms.api.entity.vacancy.CriteriaType;
import com.cvms.api.entity.vacancy.VacancyCriteria;

public interface CriteriaCalculator {
    CriteriaType getType();

    Integer calculateScore(Candidate candidate, VacancyCriteria criteria);
}
