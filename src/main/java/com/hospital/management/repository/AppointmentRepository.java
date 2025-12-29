package com.hospital.management.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hospital.management.entity.*;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findByPatient_Id(String patientId);
    List<Appointment> findByDoctor_Id(String doctorId);
    List<Appointment> findByDoctor_IdAndAppointmentDate(String doctorId, String appointmentDate);
}
