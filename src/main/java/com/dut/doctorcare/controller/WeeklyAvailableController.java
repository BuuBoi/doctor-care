package com.dut.doctorcare.controller;

import com.dut.doctorcare.dto.request.UserRegistrationDto;
import com.dut.doctorcare.dto.response.ApiResponse;
import com.dut.doctorcare.dto.response.UserResponseDto;
import com.dut.doctorcare.model.WeeklyAvailable;
import com.dut.doctorcare.repositories.WeeklyAvailableRepository;
import com.dut.doctorcare.service.iface.UserService;
import com.dut.doctorcare.service.iface.WeeklyAvailableService;
import com.dut.doctorcare.service.impl.WeeklyAvailableServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
@Slf4j
@RestController
@RequestMapping("/api/weekly-available")
public class WeeklyAvailableController {
    private final WeeklyAvailableService weeklyAvailableService;

    @Autowired
    public WeeklyAvailableController(WeeklyAvailableService weeklyAvailableService) {
        this.weeklyAvailableService = weeklyAvailableService;
    }

    @GetMapping("/grouped")
    public ApiResponse<Map<String, List<String>>> getGroupedWeeklyAvailable(
            @RequestParam("doctorId") String doctorId) {
            UUID doctorUuid = UUID.fromString(doctorId); // Chuyển từ String sang UUID
            Map<String, List<String>> groupedSchedules = weeklyAvailableService.
                    getGroupedWeeklyAvailable(doctorUuid);
            return ApiResponse.<Map<String, List<String>>>builder()
                    .status(HttpStatus.OK.value())
                    .data(groupedSchedules)
                    .build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateSchedule(@RequestParam("doctorId") String doctorId,
                                            @RequestBody Map<String, List<String>> scheduleMap) {
        try {
            UUID doctorUuid = UUID.fromString(doctorId); // Chuyển đổi doctorId từ String sang UUID
            weeklyAvailableService.updateWeeklySchedule(doctorUuid, scheduleMap);
            return ResponseEntity.ok("Cập nhật lịch thành công!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Cập nhật lịch thất bại!");
        }
    }
}

