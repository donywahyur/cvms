package com.cvms.api.mapper;

import org.springframework.stereotype.Component;

import com.cvms.api.dto.request.VacancyCriteriaRequest;
import com.cvms.api.dto.response.VacancyCriteriaResponse;
import com.cvms.api.entity.vacancy.VacancyCriteria;

@Component
public class VacancyCriteriaMapper {
    public VacancyCriteria toEntity(VacancyCriteriaRequest dto) {
        VacancyCriteria criteria = new VacancyCriteria();
        criteria.setType(dto.type());
        criteria.setMinValue(dto.minValue());
        criteria.setMaxValue(dto.maxValue());
        criteria.setGender(dto.gender());
        criteria.setWeight(dto.weight());
        return criteria;
    }

    public VacancyCriteriaResponse toResponse(VacancyCriteria entity) {
        return new VacancyCriteriaResponse(
                entity.getType(),
                entity.getGender(),
                entity.getMinValue(),
                entity.getMaxValue(),
                entity.getWeight());
    }
}
