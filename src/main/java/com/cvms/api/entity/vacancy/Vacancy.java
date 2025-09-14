package com.cvms.api.entity.vacancy;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.cvms.api.entity.BaseEntity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "vacancy")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Builder
public class Vacancy extends BaseEntity {
    private String name;

    private List<VacancyCriteria> criteria;
}
