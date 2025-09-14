package com.cvms.api.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cvms.api.dto.response.RankingResponse;
import com.cvms.api.entity.candidate.Candidate;
import com.cvms.api.entity.vacancy.CriteriaType;
import com.cvms.api.entity.vacancy.Vacancy;
import com.cvms.api.entity.vacancy.VacancyCriteria;
import com.cvms.api.exception.NotFoundException;
import com.cvms.api.repository.CandidateRepository;
import com.cvms.api.repository.VacancyRepository;
import com.cvms.api.service.calculator.CriteriaCalculator;

import lombok.AllArgsConstructor;

@Service
public class RankingServiceImpl implements RankingService {
    private final CandidateRepository candidateRepository;
    private final VacancyRepository vacancyRepository;
    private final Logger logger = Logger.getLogger(RankingServiceImpl.class.getName());
    private final List<CriteriaCalculator> calculators;
    private final Map<CriteriaType, CriteriaCalculator> calculatorMap;

    public RankingServiceImpl(CandidateRepository candidateRepository, VacancyRepository vacancyRepository,
            List<CriteriaCalculator> calculators) {
        this.candidateRepository = candidateRepository;
        this.vacancyRepository = vacancyRepository;
        this.calculators = calculators;
        this.calculatorMap = calculators.stream().collect(
                Collectors.toMap(CriteriaCalculator::getType, calculator -> calculator));
    }

    public List<RankingResponse> rankCandidate(String vacancyId) {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new NotFoundException("Vacancy not found"));

        logger.info("Ranking candidates for vacancy " + vacancyId);

        List<Candidate> candidates = candidateRepository.findAll();

        List<RankingResponse> rankingResult = candidates.stream().map(candidate -> new RankingResponse(
                candidate.getName(),
                candidate.getEmail(),
                calculateScore(candidate, vacancy)))
                .sorted(Comparator.comparingInt(RankingResponse::score).reversed())
                .toList();

        return rankingResult;
    }

    private Integer calculateScore(Candidate candidate, Vacancy vacancy) {
        logger.info("Calculating score for candidate " + candidate.getName());
        int totalScore = 0;

        for (VacancyCriteria criteria : vacancy.getCriteria()) {
            CriteriaCalculator calculator = calculatorMap.get(criteria.getType());
            Integer score = calculator.calculateScore(candidate, criteria);
            totalScore += score;
        }

        return totalScore;
    }
}
