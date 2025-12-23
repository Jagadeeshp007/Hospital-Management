package com.hospital.management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.hospital.management.entity.Appointment;
import com.hospital.management.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public Appointment book(@RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> list() {
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/{id}")
    public void cancel(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
    }
}
