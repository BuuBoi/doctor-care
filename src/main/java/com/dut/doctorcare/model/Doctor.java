package com.dut.doctorcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "doctors")
public class Doctor extends BaseClazz {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToMany
    @JoinTable(name = "doctor_symptom", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "doctor_id"), // Khóa ngoại đến bảng Doctor
            inverseJoinColumns = @JoinColumn(name = "symptom_id") // Khóa ngoại đến bảng Symptom
    )
    private List<Symptom> symptoms = new ArrayList<Symptom>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor")
    private List<HistoryMedical> historyMedicals;

    @OneToMany(mappedBy = "doctor")
    private List<Review> reviews;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    private String phone;
    private String position;
    private Patient.Gender gender;
    private LocalDate dateOfBirth;
    private String bio;
    private int experience;
    private BigDecimal price;

}
