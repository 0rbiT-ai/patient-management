package com.akhilesh.patientservice.service;

import com.akhilesh.patientservice.dto.PatientResponseDTO;
import com.akhilesh.patientservice.model.Patient;
import com.akhilesh.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    private PatientResponseDTO mapDTO(Patient patient){
        return PatientResponseDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .email(patient.getEmail())
                .address(patient.getAddress())
                .dateOfBirth(patient.getDateOfBirth())
                .build();
    }

    @Transactional(readOnly = true)
    public Page<PatientResponseDTO> getPatients(int page,
                                                int size,
                                                String sortBy,
                                                String sortDirection){

        Sort sort = sortDirection.equalsIgnoreCase("desc")?
                Sort.by(sortBy).descending():
                Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page,size,sort);

        Page<Patient> patients = patientRepository.findAll(pageable);

        return patients.map(this::mapDTO);
    }
}
