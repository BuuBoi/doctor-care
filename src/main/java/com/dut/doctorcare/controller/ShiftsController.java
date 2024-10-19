package com.dut.doctorcare.controller;

import com.dut.doctorcare.dto.request.ShiftsRequest;
import com.dut.doctorcare.dto.response.ApiResponse;
import com.dut.doctorcare.dto.response.ShiftsResponse;
import com.dut.doctorcare.service.iface.ShiftsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shifts")
@RequiredArgsConstructor
public class ShiftsController {
    private final ShiftsService shiftsService;
    @PostMapping
    public ApiResponse<ShiftsResponse> createShifts(@RequestBody ShiftsRequest shiftName) {
        ShiftsResponse shiftsResponse = shiftsService.createShifts(shiftName.getShiftName());
        return ApiResponse.<ShiftsResponse>builder()
                .status(200)
                .data(shiftsResponse)
                .build();

    }

    @GetMapping
    public ApiResponse<List<ShiftsResponse>> getAllShifts() {
        List<ShiftsResponse> shiftsResponses = shiftsService.getAllShifts();
        return ApiResponse.<List<ShiftsResponse>>builder()
                .status(200)
                .data(shiftsResponses)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteShifts(@PathVariable String id) {
        shiftsService.deleteShifts(id);
        return ApiResponse.<String>builder()
                .status(200)
                .message("Delete shifts successfully")
                .build();
    }
}
