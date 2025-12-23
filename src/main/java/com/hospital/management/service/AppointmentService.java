package com.hospital.management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.hospital.management.entity.Appointment;
import com.hospital.management.repository.AppointmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

	private final AppointmentRepository appointmentRepository;

	public Appointment bookAppointment(Appointment appointment) {
		appointment.setStatus("BOOKED");
		return appointmentRepository.save(appointment);
	}

	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	public void cancelAppointment(Long id) {
		Appointment appt = appointmentRepository.findById(id).orElseThrow();
		appt.setStatus("CANCELLED");
		appointmentRepository.save(appt);
	}
}
