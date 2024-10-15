package com.dut.doctorcare.dto.response;

import lombok.Data;

@Data
public class UserResponseDto {
    private String id;
    private String email;
    private String displayName;
    private String avatarUrl; // Optional
    private String phoneNumber; // Optional
    private String paymentInformation; // Optional
    private String roleName;
}
