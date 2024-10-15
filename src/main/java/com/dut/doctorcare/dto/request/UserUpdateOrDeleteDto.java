package com.dut.doctorcare.dto.request;

import lombok.Data;

@Data
public class UserUpdateOrDeleteDto {
    private String id;
    private String displayName;
    private String avatarUrl; // Optional
    private String phoneNumber; // Optional
    private String paymentInformation; // Optional
}
