package com.hospital.management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.hospital.management.dto.AppointmentDetails;
import com.hospital.management.dto.AppointmentRequest;
import com.hospital.management.dto.DoctorAppointment;
import com.hospital.management.dto.PatientAppointment;
import com.hospital.management.entity.Appointment;
import com.hospital.management.service.AppointmentService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

	private final AppointmentService service;

	@PostMapping
	public Appointment book(@RequestBody AppointmentRequest a) {
		System.out.println("appointment");
		return service.book(a);
	}

	@GetMapping
	public List<AppointmentDetails> all() {
		return service.all();
	}

	@GetMapping("/patient/{id}")
	public List<AppointmentDetails> byPatient(@PathVariable Long id) {
		return service.byPatient(id);
	}

	@GetMapping("/doctor/{id}")
	public List<AppointmentDetails> byDoctor(@PathVariable Long id) {
		return service.byDoctor(id);
	}

	@PutMapping("/status/{id}")
	public PatientAppointment update(@PathVariable Long id, @RequestBody Map<String, String> req) {
		return service.updateStatus(id, req.get("status"));
	}

	@GetMapping("/slots")
	public List<String> bookedSlots(@RequestParam Long doctorId, @RequestParam String date) {

		return service.bookedSlots(doctorId, date);
	}

}
