package com.akhilesh.patientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String address;
    private LocalDate dateOfBirth;
}
