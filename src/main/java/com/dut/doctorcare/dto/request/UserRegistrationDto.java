package com.dut.doctorcare.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationDto {
    @Email(message = "INVALID_EMAIL")
    private String email;

    @Size(min = 6,message = "INVALID_DISPLAY_NAME")
    private String displayName;
    @Size(min = 6,message = "INVALID_PASSWORD")
    private String password;
    private String avatarUrl; // Optional
    private String phoneNumber; // Optional
    private String paymentInformation; // Optional
}
