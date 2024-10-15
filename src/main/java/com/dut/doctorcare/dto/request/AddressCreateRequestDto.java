package com.dut.doctorcare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressCreateRequestDto {
    @NotBlank(message = "INVALID_ADDRESS")
    private String province;
    @NotBlank(message = "INVALID_ADDRESS")
    private String district;

    @NotBlank(message = "INVALID_ADDRESS")
    private String ward;

    @NotBlank
    @Size(max = 255, message = "INVALID_ADDRESS")
    private String details;
}
