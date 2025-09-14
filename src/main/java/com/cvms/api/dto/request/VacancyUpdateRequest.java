package com.cvms.api.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VacancyUpdateRequest(
                @NotBlank(message = "Name is required") String name,
                @NotNull(message = "Criteria is required") @Size(min = 1, message = "At least one criteria is required") List<VacancyCriteriaRequest> criteria) {

}
