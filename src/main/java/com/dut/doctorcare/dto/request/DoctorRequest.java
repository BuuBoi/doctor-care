package com.dut.doctorcare.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class DoctorRequest extends UserBaseDto {
    private String position;
    private String bio;
    private int experience;
    private BigDecimal price;
    private SpecializationDto specializationDto;
}
