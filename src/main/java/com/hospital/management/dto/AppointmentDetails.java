package com.hospital.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hospital.management.entity.AppointmentStatus;
import com.hospital.management.entity.Department;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentDetails {

	private Long id;
	private Department department;
	private String patientName;
	private String doctorName;
	private String phoneNumber;
	private String date;
	private String time;
	private AppointmentStatus status;
}
