package com.dut.doctorcare.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationDto {
    @NotBlank(message = "Email is required")
    @Email(message = "INVALID_EMAIL")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6,message = "INVALID_PASSWORD")
    private String password;

    @NotBlank(message = "Full name is required")
    @JsonProperty("fname")
    private String fullName;

    @JsonProperty("role")
    private String role;
}
