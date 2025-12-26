package com.hospital.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentRequest {

	private Long patientId;
	private Long doctorId;

	private String date;
	private String time;
}
