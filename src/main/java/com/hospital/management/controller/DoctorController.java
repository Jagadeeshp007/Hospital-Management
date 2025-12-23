package com.hospital.management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.entity.Appointment;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final AppointmentRepository appointmentRepository;

    @GetMapping("/appointments")
    public List<Appointment> viewAppointments() {
        return appointmentRepository.findAll();
    }
}
