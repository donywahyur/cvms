package com.cvms.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cvms.api.entity.candidate.Candidate;

public interface CandidateRepository extends MongoRepository<Candidate, String> {

    boolean existsByEmail(String email);

    Candidate findByEmail(
            String email);

    boolean existsByEmailAndIdNot(
            String email, String id);

}
