package com.dut.doctorcare.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "roles")
public class Role extends BaseClazz {
	@Enumerated(EnumType.STRING)
	@Column(name = "role_name", nullable = false, unique = true)
	private RoleName roleName;

	@OneToMany(mappedBy = "role")
	private List<User> users = new ArrayList<>();

	public enum RoleName {
		ADMIN, DOCTOR, PATIENT
	}

}
