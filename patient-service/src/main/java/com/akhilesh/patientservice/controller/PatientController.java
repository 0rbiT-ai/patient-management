package com.akhilesh.patientservice.controller;

import com.akhilesh.patientservice.dto.PatientResponseDTO;
import com.akhilesh.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<Page<PatientResponseDTO>> getPatients(@RequestParam(required = false, defaultValue = "0") int page,
                                                                @RequestParam(required = false, defaultValue = "10") int size,
                                                                @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                @RequestParam(required = false, defaultValue = "asc") String sortDirection){
        return ResponseEntity.ok().body(patientService.getPatients(page,size,sortBy,sortDirection));
    }

}
