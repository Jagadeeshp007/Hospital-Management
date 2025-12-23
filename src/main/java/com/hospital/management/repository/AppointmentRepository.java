package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.management.entity.*;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
