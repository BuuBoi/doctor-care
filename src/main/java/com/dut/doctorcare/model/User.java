package com.dut.doctorcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
