package com.dut.doctorcare.service.iface;

import com.dut.doctorcare.dto.request.ScheduleRequest;
import com.dut.doctorcare.dto.response.ScheduleResponse;

import java.util.List;

public interface ScheduleService {
    List<ScheduleResponse> createSchedule(ScheduleRequest request);
}
