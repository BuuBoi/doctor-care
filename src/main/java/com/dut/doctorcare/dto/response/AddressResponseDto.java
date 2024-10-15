package com.dut.doctorcare.dto.response;


import com.dut.doctorcare.model.Address;
import lombok.Data;

@Data
public class AddressResponseDto {
    private String id; // ID của địa chỉ
    private String province;
    private String district;
    private String ward;
    private String details;

    public AddressResponseDto(Address address) {
        this.id = address.getId().toString();
        this.province = address.getProvince();
        this.district = address.getDistrict();
        this.ward = address.getWard();
        this.details = address.getDetails();

    }
}

