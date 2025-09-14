package com.cvms.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvms.api.dto.response.ApiResponse;
import com.cvms.api.dto.response.RankingResponse;
import com.cvms.api.service.RankingService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/ranking")
@AllArgsConstructor
public class RankingController {
    private final RankingService rankingService;

    @GetMapping("/{vacancyId}")
    public ResponseEntity<ApiResponse<List<RankingResponse>>> rankCandidate(@PathVariable String vacancyId) {
        List<RankingResponse> ranking = rankingService.rankCandidate(vacancyId);
        return ResponseEntity.ok().body(ApiResponse.ok(ranking));
    }

}
