package com.dut.doctorcare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "specialists")
public class Specialization extends BaseClazz{

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "specialization")
    private Set<Doctor> doctors;

}
