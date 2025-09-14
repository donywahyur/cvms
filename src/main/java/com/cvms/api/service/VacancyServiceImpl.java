package com.cvms.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cvms.api.dto.request.VacancyCreateRequest;
import com.cvms.api.dto.request.VacancyCriteriaRequest;
import com.cvms.api.dto.request.VacancyUpdateRequest;
import com.cvms.api.dto.response.VacancyResponse;
import com.cvms.api.entity.vacancy.CriteriaType;
import com.cvms.api.entity.vacancy.Vacancy;
import com.cvms.api.exception.BadRequestException;
import com.cvms.api.exception.NotFoundException;
import com.cvms.api.mapper.VacancyMapper;
import com.cvms.api.repository.VacancyRepository;
import com.cvms.api.service.validator.CriteriaValidator;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final VacancyMapper vacancyMapper;
    private final List<CriteriaValidator> validators;
    private final Logger logger = Logger.getLogger(VacancyServiceImpl.class.getName());

    public VacancyResponse createVacancy(VacancyCreateRequest request) {
        logger.info("Creating vacancy" + request);
        validateCriteria(request.criteria());
        Vacancy vacancy = vacancyMapper.toEntity(request);
        return vacancyMapper.toResponse(vacancyRepository.save(vacancy));
    }

    public Page<VacancyResponse> getAllVacancies(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return vacancyRepository.findAll(pageable).map(vacancyMapper::toResponse);
    }

    public VacancyResponse updateVacancy(String id, VacancyUpdateRequest request) {
        logger.info("Updating vacancy" + request);
        Vacancy vacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vacancy not found"));

        Vacancy updatedVacancy = vacancyMapper.updateEntity(vacancy, request);
        return vacancyMapper.toResponse(vacancyRepository.save(updatedVacancy));
    }

    public void deleteVacancy(String id) {
        logger.info("Deleteing vacancy" + id);
        Vacancy vacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vacancy not found"));

        if (vacancy == null) {
            throw new NotFoundException("Vacancy not found");
        }

        vacancyRepository.delete(vacancy);
    }

    private void validateCriteria(List<VacancyCriteriaRequest> criteria) {
        Set<CriteriaType> uniqueCriteria = new HashSet<>();

        for (VacancyCriteriaRequest c : criteria) {
            if (!uniqueCriteria.add(c.type())) {
                throw new BadRequestException("Duplicate criteria found");
            }

            for (CriteriaValidator validator : validators) {
                if (validator.supports(c.type())) {
                    validator.validate(c);
                }
            }
        }

    }
}
