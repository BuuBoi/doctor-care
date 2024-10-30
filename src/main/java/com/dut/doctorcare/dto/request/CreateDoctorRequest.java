package com.dut.doctorcare.dto.request;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateDoctorRequest extends DoctorRequest{
    private UserRegistrationDto userRegistrationDto;
}
