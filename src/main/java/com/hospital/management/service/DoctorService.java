package com.hospital.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.management.entity.Department;
import com.hospital.management.entity.Doctor;
import com.hospital.management.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService {

	private final DoctorRepository repo;

	public Doctor register(Doctor d) {
		return repo.save(d);
	}

	public List<Doctor> findAll() {
		return repo.findAll();
	}
	
	public List<Doctor> findByDepartMent(Department department){
		List<Doctor> byDepartment = repo.findByDepartment(department);
		System.out.println("byDepartment"+byDepartment);
		return byDepartment;
	}
}
