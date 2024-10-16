package com.dut.doctorcare.dto.response;

import com.dut.doctorcare.model.Appointment;
import com.dut.doctorcare.model.Doctor;
import com.dut.doctorcare.model.Patient;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {
    private LocalDate date;
    private String status;
    private Double fee;
    private DoctorResponse doctorResponse;
    private PatientResponse patientResponse;
}
