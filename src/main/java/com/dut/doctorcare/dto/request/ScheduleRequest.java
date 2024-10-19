package com.dut.doctorcare.dto.request;

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
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequest {
    private String id;

    private String date;

    private List<ShiftsRequest> shifts;
}
