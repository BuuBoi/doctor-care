package com.dut.doctorcare.service.iface;

import com.dut.doctorcare.dto.request.ScheduleRequest;
import com.dut.doctorcare.dto.response.ScheduleResponse;
import com.dut.doctorcare.dto.response.ShiftsResponse;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    List<ScheduleResponse> createSchedule(ScheduleRequest request);
    List<ShiftsResponse> getShiftsAvailable(LocalDate date);
}
