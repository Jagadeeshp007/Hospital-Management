package com.hospital.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.management.entity.*;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	Optional<Patient> findByUsernameAndPassword(String username, String password);
}