package com.dut.doctorcare.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Builder
public class ApiResponse<T> {

    public ApiResponse() {
    }
    private String message;
    private int status = 200;
    T data;


}
