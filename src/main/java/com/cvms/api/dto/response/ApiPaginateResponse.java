package com.cvms.api.dto.response;

import java.util.List;

import lombok.Builder;

@Builder
public record ApiPaginateResponse<T>(
        boolean success,
        String message,
        List<T> data,
        long totalElements,
        int totalPages,
        int currentPage,
        int pageSize) {

    public static <T> ApiPaginateResponse<T> of(
            List<T> data,
            long totalElements,
            int totalPages,
            int currentPage,
            int pageSize) {
        return new ApiPaginateResponse<>(
                true,
                "Success",
                data,
                totalElements,
                totalPages,
                currentPage,
                pageSize);
    }
}