package com.dut.doctorcare.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "roles")
public class Role extends BaseClazz {

	@Column(name = "role_name", nullable = false, unique = true)
	private String roleName;

	@OneToMany(mappedBy = "role")
	private List<User> users = new ArrayList<>();

}
