package com.cvms.api.service.calculator;

import com.cvms.api.entity.candidate.Candidate;
import com.cvms.api.entity.vacancy.VacancyCriteria;

public interface CriteriaCalculator {
    Integer calculateScore(Candidate candidate, VacancyCriteria criteria);
}
