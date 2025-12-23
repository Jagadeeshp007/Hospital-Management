package com.hospital.management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.hospital.management.entity.Patient;
import com.hospital.management.repository.PatientRepository;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    @PostMapping("/register")
    public Patient register(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
}
