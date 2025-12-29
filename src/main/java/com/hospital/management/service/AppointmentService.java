package com.hospital.management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.management.dto.AppointmentDetails;
import com.hospital.management.dto.AppointmentRequest;
import com.hospital.management.dto.DoctorAppointment;
import com.hospital.management.dto.PatientAppointment;
import com.hospital.management.entity.Appointment;
import com.hospital.management.entity.AppointmentStatus;
import com.hospital.management.entity.Doctor;
import com.hospital.management.entity.Patient;
import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.repository.DoctorRepository;
import com.hospital.management.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

	private final AppointmentRepository repo;
	private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

	public Appointment book(AppointmentRequest request) {
		Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = Appointment.builder()
                .patient(patient)      // ✅ SET ENTITY
                .doctor(doctor)        // ✅ SET ENTITY
                .patientName(patient.getFirstName()+" "+patient.getLastName())
                .patientPhone(patient.getPhone())
                .doctorName(doctor.getFirstName()+" "+doctor.getLastName())
                .appointmentDate(request.getDate())
                .appointmentTime(request.getTime())
                .status(AppointmentStatus.BOOKED)
                .createdBy("PATIENT")
                .build();
        appointment.setStatus(AppointmentStatus.BOOKED);
		System.out.println("booking detials :"+appointment);
		return repo.save(appointment);
	}

	public List<AppointmentDetails> all() {
		List<Appointment> appointment = repo.findAll();
		
		List<AppointmentDetails> appointmentList = new ArrayList<>();
		appointment.stream().forEach(appoint->{
			AppointmentDetails appointmentDetails = AppointmentDetails.builder()
					.id(appoint.getId())
					.department(appoint.getDoctor().getDepartment())
					.doctorName(appoint.getDoctor().getFirstName()+" "+appoint.getDoctor().getLastName())
					.patientName(appoint.getPatient().getFirstName()+" "+appoint.getPatient().getLastName())
					.date(appoint.getAppointmentDate())
					.time(appoint.getAppointmentTime())
					.status(appoint.getStatus())
					.build();
			
			appointmentList.add(appointmentDetails);
		});
		return appointmentList;
	}

	public List<AppointmentDetails> byPatient(String id) {
		List<Appointment> appointment = repo.findByPatient_Id(id);
		
		List<AppointmentDetails> appointmentList = new ArrayList<>();
		appointment.stream().forEach(appoint->{
			AppointmentDetails appointmentDetails = AppointmentDetails.builder()
					.id(appoint.getId())
					.department(appoint.getDoctor().getDepartment())
					.doctorName(appoint.getDoctor().getFirstName()+" "+appoint.getDoctor().getLastName())
					.phoneNumber(appoint.getDoctor().getPhone())
					.date(appoint.getAppointmentDate())
					.time(appoint.getAppointmentTime())
					.status(appoint.getStatus())
					.build();
			
			appointmentList.add(appointmentDetails);
		});
		
		return appointmentList;
	}

	public List<AppointmentDetails> byDoctor(String id) {
		List<Appointment> appointment = repo.findByDoctor_Id(id);
		
		List<AppointmentDetails> appointmentList = new ArrayList<>();
		appointment.stream().forEach(appoint->{
			AppointmentDetails appointmentDetails = AppointmentDetails.builder()
					.id(appoint.getId())
					.department(appoint.getDoctor().getDepartment())
					.patientName(appoint.getPatient().getFirstName()+" "+appoint.getPatient().getLastName())
					.phoneNumber(appoint.getPatient().getPhone())
					.date(appoint.getAppointmentDate())
					.time(appoint.getAppointmentTime())
					.status(appoint.getStatus())
					.build();
			
			appointmentList.add(appointmentDetails);
		});
		
		return appointmentList;
		
	}

	public PatientAppointment updateStatus(String id, String status) {
		Appointment appoint = repo.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
		appoint.setStatus(AppointmentStatus.valueOf(status));
		Appointment appointment = repo.save(appoint);
		PatientAppointment patientAppointment = PatientAppointment.builder()
				.id(appointment.getId())
				.department(appointment.getDoctor().getDepartment())
				.doctorName(appointment.getDoctor().getFirstName() + " " + appointment.getDoctor().getLastName())
				.date(appointment.getAppointmentDate())
				.time(appointment.getAppointmentTime())
				.status(appointment.getStatus())
				.build();
		return patientAppointment;
	}

	public List<String> bookedSlots(String doctorId, String date) {

		return repo.findByDoctor_IdAndAppointmentDate(doctorId, date).stream().map(Appointment::getAppointmentTime)
				.toList();
	}
}
