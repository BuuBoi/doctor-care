package com.dut.doctorcare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dut.doctorcare.dto.response.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "HealthCheck", description = "APIs for health check")
@RestController
@RequestMapping("/api/health-check")
public class HealthCheck {

    @Operation(summary = "Check health", description = "Check health of the application")
    @GetMapping
    public String check() {
        return ApiResponse.builder()
                .status(200)
                .message("Health check success")
                .build()
                .toString();
    }
}
