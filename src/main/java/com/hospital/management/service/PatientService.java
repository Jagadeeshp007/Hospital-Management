package com.hospital.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.management.entity.Patient;
import com.hospital.management.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

	private final PatientRepository repo;

	public Patient register(Patient p) {
		return repo.save(p);
	}

	public List<Patient> findAll() {
		return repo.findAll();
	}
}
