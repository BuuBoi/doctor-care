package com.dut.doctorcare.dto.response;

import com.dut.doctorcare.dto.request.UserBaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse extends UserBaseDto {
    private List<HistoryMedicalResponse> historyMedicalResponses;
    private List<AppointmentResponse> appointmentResponses;
}
