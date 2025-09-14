package com.cvms.api.dto.request;

import java.time.LocalDate;

import com.cvms.api.entity.candidate.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CandidateUpdateRequest(
                @NotBlank(message = "Name is required") String name,

                @NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,

                @NotNull(message = "Birthdate is required") @Past(message = "Birthdate must be in the past") LocalDate birthdate,

                @NotNull(message = "Gender is required") Gender gender,

                @NotNull(message = "Current salary is required") @Min(value = 0, message = "Current salary must be at least 0") Double currentSalary) {
}
