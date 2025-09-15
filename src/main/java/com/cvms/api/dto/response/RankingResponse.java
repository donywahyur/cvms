package com.cvms.api.dto.response;

public record RankingResponse(
        String candidateId,
        String candidateName,
        String email,
        Integer score) {

}
