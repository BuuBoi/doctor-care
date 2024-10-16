package com.dut.doctorcare.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryMedicalResponse {
    private String id;
    private LocalDateTime createdAt;
    private String PrescriptionNotes;
}
