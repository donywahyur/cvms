package com.cvms.api.service;

import java.util.List;

import com.cvms.api.dto.response.RankingResponse;

public interface RankingService {
    List<RankingResponse> rankCandidate(String vacancyId);
}
