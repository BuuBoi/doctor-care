package com.dut.doctorcare.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class AuthenticationRequest {
    @Email(message = "INVALID_EMAIL")
    String email;
    @Size(min = 6, message = "INVALID_PASSWORD")
    String password;
}
