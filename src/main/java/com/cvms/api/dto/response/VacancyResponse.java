package com.cvms.api.dto.response;

import java.util.List;

public record VacancyResponse(
        String id,
        String name,
        List<VacancyCriteriaResponse> criteria) {

}
