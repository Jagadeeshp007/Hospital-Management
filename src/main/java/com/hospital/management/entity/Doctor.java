package com.hospital.management.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "doctors")
//@Entity
//@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Doctor {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false, unique = true)
	private String username; // loginId

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String phone;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Department department;
}


