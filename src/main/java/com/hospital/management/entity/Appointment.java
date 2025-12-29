package com.hospital.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appointments")
@CompoundIndexes({
    @CompoundIndex(
        name = "doctor_date_time_unique",
        def = "{'doctorId': 1, 'appointmentDate': 1, 'appointmentTime': 1}",
        unique = true
    )
})
//@Entity
//@Table(
//    name = "appointments",
//    uniqueConstraints = {
//        @UniqueConstraint(
//            columnNames = {"doctor_id", "appointmentDate", "appointmentTime"}
//        )
//    }
//)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Appointment {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /* ================= PATIENT ================= */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    /* ================= DOCTOR ================= */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
    
    @Column(nullable = false)
    private String patientName;
    
    @Column(nullable = false)
    private String patientPhone;
    
    @Column(nullable = false)
    private String doctorName;

    /* ================= DATE & TIME ================= */
    @Column(nullable = false)
    private String appointmentDate; // yyyy-MM-dd

    @Column(nullable = false)
    private String appointmentTime; // 10:00, 12:00...

    /* ================= STATUS ================= */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status;

    /* ================= AUDIT ================= */
    private String createdBy; // PATIENT / DOCTOR / ADMIN
}
