package com.dut.doctorcare.dto.response;

import com.dut.doctorcare.model.Schedule;
import com.dut.doctorcare.model.Shifts;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponse {
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Schedule.Status status;
    private ShiftsResponse shiftsReponse;
}
