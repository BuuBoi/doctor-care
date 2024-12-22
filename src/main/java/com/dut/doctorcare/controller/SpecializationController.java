package com.dut.doctorcare.controller;

import com.dut.doctorcare.dto.request.SpecializationDto;
import com.dut.doctorcare.dto.response.ApiResponse;
import com.dut.doctorcare.service.iface.SpecializationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/specs")
@RequiredArgsConstructor
public class SpecializationController {
    private final SpecializationService specializationService;

    @PostMapping("/create")
    public ApiResponse<SpecializationDto> createSpecialization(@RequestBody SpecializationDto specializationDto) {
        SpecializationDto specializationDto1 = specializationService.createSpecialization(specializationDto.getName());
        return ApiResponse.<SpecializationDto>builder()
                .status(200)
                .data(specializationDto1)
                .build();

    }

    @GetMapping
    public ApiResponse<List<SpecializationDto>> getAllSpecializations() {
        List<SpecializationDto> specializationDtoList = specializationService.getAllSpecialization();
        return ApiResponse.<List<SpecializationDto>>builder()
                .status(200)
                .data(specializationDtoList)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteSpecialization(@PathVariable String id) {
        specializationService.deleteSpecialization(id);
        return ApiResponse.<String>builder()
                .status(200)
                .data("Specialization deleted")
                .build();
    }
}
