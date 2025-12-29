package com.hospital.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hospital.management.entity.*;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    Optional<Doctor> findByUsernameAndPassword(String username, String password);

	List<Doctor> findByDepartment(Department department);
}
