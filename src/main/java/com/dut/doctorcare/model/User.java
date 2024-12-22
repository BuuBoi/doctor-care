package com.dut.doctorcare.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "users")
public class User extends BaseClazz {

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Patient patient;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Doctor doctor;

	public String getFullName() {
		if (this.patient != null) {
			return this.patient.getFullName();
		}
		if (this.doctor != null) {
			return this.doctor.getFullName();
		}
		return null;
	}
}
