package com.cvms.api.service;

import org.springframework.data.domain.Page;

import com.cvms.api.dto.request.VacancyCreateRequest;
import com.cvms.api.dto.request.VacancyUpdateRequest;
import com.cvms.api.dto.response.VacancyResponse;

public interface VacancyService {
    VacancyResponse createVacancy(VacancyCreateRequest request);

    Page<VacancyResponse> getAllVacancies(Integer page, Integer size);

    VacancyResponse updateVacancy(String id, VacancyUpdateRequest request);

    void deleteVacancy(String id);
}
