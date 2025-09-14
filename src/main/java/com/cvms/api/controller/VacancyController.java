package com.cvms.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cvms.api.dto.request.VacancyCreateRequest;
import com.cvms.api.dto.request.VacancyUpdateRequest;
import com.cvms.api.dto.response.ApiPaginateResponse;
import com.cvms.api.dto.response.ApiResponse;
import com.cvms.api.dto.response.VacancyResponse;
import com.cvms.api.service.VacancyService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/vacancies")
@AllArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @PostMapping("")
    public ResponseEntity<ApiResponse<VacancyResponse>> createVacancy(
            @Valid @RequestBody VacancyCreateRequest request) {
        VacancyResponse vacancy = vacancyService.createVacancy(request);
        return ResponseEntity.ok().body(ApiResponse.ok(vacancy));
    }

    @GetMapping("")
    public ResponseEntity<ApiPaginateResponse<VacancyResponse>> getAllVacancy(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<VacancyResponse> vacancies = vacancyService.getAllVacancies(page, size);
        return ResponseEntity.ok(ApiPaginateResponse.of(vacancies.getContent(), vacancies.getTotalElements(),
                vacancies.getTotalPages(), page, size));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<VacancyResponse>> updateVacancy(@PathVariable String id,
            @Valid @RequestBody VacancyUpdateRequest request) {
        VacancyResponse vacancy = vacancyService.updateVacancy(id, request);

        return ResponseEntity.ok().body(ApiResponse.ok(vacancy));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacancy(@PathVariable String id) {
        vacancyService.deleteVacancy(id);
        return ResponseEntity.noContent().build();
    }

}
