package com.dut.doctorcare.dto.response;

import com.dut.doctorcare.dto.request.DoctorDto;
import com.dut.doctorcare.dto.request.UserBaseDto;
import com.dut.doctorcare.model.Appointment;
import com.dut.doctorcare.model.HistoryMedical;
import com.dut.doctorcare.model.Review;
import com.dut.doctorcare.model.Schedule;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponse extends DoctorDto {
    private String id;
    private List<AppointmentResponse> appointmentResponses;
    private List<HistoryMedicalResponse> historyMedicalResponses;
    private List<ReviewResponse> reviewResponses;
    private List<ScheduleResponse> scheduleResponses;
}
