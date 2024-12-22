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
@Table(name = "weekly_availlable")
public class WeeklyAvailable extends BaseClazz {
    @Column(name = "date_of_week")
    private String dateOfWeek;

    @Column(name = "time_slot")
    private String timeSlot;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
