package com.dut.doctorcare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressUpdateOrDeleteDto {
    @NotBlank(message = "Address id is required.")
    private String id;
    @NotBlank(message = "Province is required.")
    private String province;
    @NotBlank(message = "District is required")
    private String district;

    @NotBlank(message = "Ward is required")
    private String ward;

    @NotBlank
    @Size(max = 255, message = "Specific address is too long")
    private String details;
}
