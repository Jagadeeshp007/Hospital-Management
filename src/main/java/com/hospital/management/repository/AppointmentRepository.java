package com.hospital.management.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.management.entity.*;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatient_Id(Long patientId);
    List<Appointment> findByDoctor_Id(Long doctorId);
    List<Appointment> findByDoctor_IdAndAppointmentDate(Long doctorId, String appointmentDate);
}
