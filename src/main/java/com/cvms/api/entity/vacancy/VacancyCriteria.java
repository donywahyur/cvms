package com.cvms.api.entity.vacancy;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class VacancyCriteria {

    public static final String CriteriaType = null;

    private CriteriaType type;

    @Field("min_value")
    private Integer minValue;

    @Field("max_value")
    private Integer maxValue;

    private Gender gender;

    private Integer weight = 1;

}
