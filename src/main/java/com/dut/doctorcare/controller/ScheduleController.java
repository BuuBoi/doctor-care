package com.dut.doctorcare.controller;

import com.dut.doctorcare.dto.request.ScheduleRequest;
import com.dut.doctorcare.dto.response.ApiResponse;
import com.dut.doctorcare.dto.response.ScheduleResponse;
import com.dut.doctorcare.service.iface.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    @PostMapping
    public ApiResponse<List<ScheduleResponse>> createSchedule(@RequestBody ScheduleRequest scheduleRequest) {
        List<ScheduleResponse> scheduleResponses = scheduleService.createSchedule(scheduleRequest);
        return ApiResponse.<List<ScheduleResponse>>builder()
                .status(200)
                .data(scheduleResponses)
                .build();
    }

}
