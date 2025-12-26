package com.hospital.management.service;

import org.springframework.stereotype.Service;

import com.hospital.management.entity.Doctor;
import com.hospital.management.entity.Patient;
import com.hospital.management.repository.DoctorRepository;
import com.hospital.management.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final PatientRepository patientRepo;
	private final DoctorRepository doctorRepo;

	public Patient patientLogin(String u, String p) {
		return patientRepo.findByUsernameAndPassword(u, p)
				.orElseThrow(() -> new RuntimeException("Invalid patient login"));
	}

	public Doctor doctorLogin(String u, String p) {
		return doctorRepo.findByUsernameAndPassword(u, p)
				.orElseThrow(() -> new RuntimeException("Invalid doctor login"));
	}
}
