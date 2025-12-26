package com.hospital.management.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.entity.Doctor;
import com.hospital.management.entity.Patient;
import com.hospital.management.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

	private final AuthService service;

	@PostMapping("/patient/login")
	public Patient patientLogin(@RequestBody Map<String, String> req) {
		return service.patientLogin(req.get("username"), req.get("password"));
	}

	@PostMapping("/doctor/login")
	public Doctor doctorLogin(@RequestBody Map<String, String> req) {
		return service.doctorLogin(req.get("username"), req.get("password"));
	}

	@PostMapping("/admin/login")
	public Map<String, String> adminLogin(@RequestBody Map<String, String> req) {
		if ("admin".equals(req.get("username")) && "admin".equals(req.get("password"))) {
			return Map.of("role", "ADMIN");
		}
		throw new RuntimeException("Invalid admin login");
	}
}
