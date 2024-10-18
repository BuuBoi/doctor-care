package com.dut.doctorcare.dto.response;

import com.dut.doctorcare.dto.request.DoctorRequest;
import com.dut.doctorcare.dto.request.SpecializationDto;
import com.dut.doctorcare.dto.request.UserBaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DoctorResponse extends UserBaseDto {
    private String position;
    private String bio;
    private int experience;
    private BigDecimal price;
    private SpecializationDto specializationDto;
    //private List<AppointmentResponse> appointmentResponses;
    //private List<HistoryMedicalResponse> historyMedicalResponses;
    //private List<ReviewResponse> reviewResponses;
    //private List<ScheduleResponse> scheduleResponses;
}
