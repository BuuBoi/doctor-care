package com.dut.doctorcare.service.iface;

import com.dut.doctorcare.dto.request.UserRegistrationDto;
import com.dut.doctorcare.dto.response.UserResponseDto;

public interface RegistrationService {
    UserResponseDto registerUser(UserRegistrationDto registrationDto);
}
