package com.hospital.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hospital.management.entity.*;

public interface PatientRepository extends MongoRepository<Patient, String> {
	Optional<Patient> findByUsernameAndPassword(String username, String password);
}