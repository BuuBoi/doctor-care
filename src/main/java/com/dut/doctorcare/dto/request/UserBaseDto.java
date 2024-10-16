package com.dut.doctorcare.dto.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBaseDto {
    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String gender;

    private LocalDate dateOfBirth;

    private AddressDto addressDto;
}
