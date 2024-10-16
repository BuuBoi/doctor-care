package com.dut.doctorcare.dto.request;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String province;
    private String district;
    private String ward;
    private String details;
}
