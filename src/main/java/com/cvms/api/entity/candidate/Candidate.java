package com.cvms.api.entity.candidate;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.cvms.api.entity.BaseEntity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Builder
@Document(collection = "candidate")
public class Candidate extends BaseEntity {
    private String name;

    @Indexed(unique = true)
    private String email;

    private LocalDate birthdate;

    private Gender gender;

    @Field("current_salary")
    private Double currentSalary;
}
