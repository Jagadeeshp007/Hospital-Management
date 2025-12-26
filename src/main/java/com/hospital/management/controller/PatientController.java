package com.hospital.management.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.hospital.management.entity.Patient;
import com.hospital.management.repository.PatientRepository;
import com.hospital.management.service.PatientService;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@CrossOrigin
public class PatientController {

    private final PatientService service;

    @PostMapping("/register")
    public Patient register(@RequestBody Patient p) {
        return service.register(p);
    }

    @GetMapping
    public List<Patient> all() {
        return service.findAll();
    }
}

