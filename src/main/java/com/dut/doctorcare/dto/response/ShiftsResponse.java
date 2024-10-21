package com.dut.doctorcare.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShiftsResponse {
    private String id;
    private String shiftName;
    private boolean scheduled;
}
