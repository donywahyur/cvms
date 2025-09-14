package com.cvms.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cvms.api.entity.vacancy.Vacancy;

public interface VacancyRepository extends MongoRepository<Vacancy, String> {

}
