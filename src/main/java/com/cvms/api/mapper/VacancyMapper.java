package com.cvms.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cvms.api.dto.request.VacancyCreateRequest;
import com.cvms.api.dto.request.VacancyCriteriaRequest;
import com.cvms.api.dto.request.VacancyUpdateRequest;
import com.cvms.api.dto.response.VacancyCriteriaResponse;
import com.cvms.api.dto.response.VacancyResponse;
import com.cvms.api.entity.vacancy.Vacancy;
import com.cvms.api.entity.vacancy.VacancyCriteria;

@Component
public class VacancyMapper {
    private final VacancyCriteriaMapper vacancyCriteriaMapper;

    public VacancyMapper(VacancyCriteriaMapper vacancyCriteriaMapper) {
        this.vacancyCriteriaMapper = vacancyCriteriaMapper;
    }

    public Vacancy toEntity(VacancyCreateRequest dto) {
        List<VacancyCriteria> criteria = new ArrayList<>();

        for (VacancyCriteriaRequest c : dto.criteria()) {
            criteria.add(vacancyCriteriaMapper.toEntity(c));
        }

        return Vacancy.builder()
                .name(dto.name())
                .criteria(criteria)
                .build();
    }

    public VacancyResponse toResponse(Vacancy entity) {
        List<VacancyCriteriaResponse> criteria = new ArrayList<>();

        for (VacancyCriteria c : entity.getCriteria()) {
            criteria.add(vacancyCriteriaMapper.toResponse(c));
        }

        return new VacancyResponse(
                entity.getId(),
                entity.getName(),
                criteria);
    }

    public Vacancy updateEntity(Vacancy entity, VacancyUpdateRequest dto) {
        List<VacancyCriteria> criteria = new ArrayList<>();
        for (VacancyCriteriaRequest c : dto.criteria()) {
            criteria.add(vacancyCriteriaMapper.toEntity(c));
        }

        entity.setName(dto.name());
        entity.setCriteria(criteria);
        return entity;
    }
}
