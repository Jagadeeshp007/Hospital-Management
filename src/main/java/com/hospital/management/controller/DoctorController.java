package com.hospital.management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.repository.DoctorRepository;
import com.hospital.management.service.DoctorService;
import com.hospital.management.entity.Appointment;
import com.hospital.management.entity.Department;
import com.hospital.management.entity.Doctor;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
@CrossOrigin
public class DoctorController {

    private final DoctorService service;

    @PostMapping("/register")
    public Doctor register(@RequestBody Doctor d) {
        return service.register(d);
    }

    @GetMapping
    public List<Doctor> all() {
        return service.findAll();
    }
    
    @GetMapping("/department/{dept}")
	public List<Doctor> byDoctor(@PathVariable String dept) {
    	System.out.println("dept: "+dept);
		return service.findByDepartMent(Department.valueOf(dept.toUpperCase()));
	}
}

