package com.hospital.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.management.entity.*;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUsernameAndPassword(String username, String password);

	List<Doctor> findByDepartment(Department department);
}
