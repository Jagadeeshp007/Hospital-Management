package com.hospital.management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.hospital.management.entity.*;
import com.hospital.management.repository.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

	private final DoctorRepository doctorRepo;
//	private final DepartmentRepository deptRepo;
	private final AppointmentRepository apptRepo;

	@PostMapping("/doctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorRepo.save(doctor);
	}

//	@PostMapping("/department")
//	public Department addDepartment(@RequestBody Department dept) {
//		return deptRepo.save(dept);
//	}

	@GetMapping("/appointments")
	public List<Appointment> getAllAppointments() {
		return apptRepo.findAll();
	}
}
