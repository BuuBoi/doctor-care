package com.dut.doctorcare.controller;

import com.dut.doctorcare.dto.request.UserRegistrationDto;
import com.dut.doctorcare.dto.response.ApiResponse;
import com.dut.doctorcare.dto.response.UserResponseDto;
import com.dut.doctorcare.service.iface.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public ApiResponse<UserResponseDto> registerUser(@Valid @RequestBody UserRegistrationDto registrationDto) {
        UserResponseDto userResponse = registrationService.registerUser(registrationDto);
        return ApiResponse.<UserResponseDto>builder()
                .status(HttpStatus.OK.value())
                .data(userResponse)
                .message("User registered successfully")
                .build();
    }
}
