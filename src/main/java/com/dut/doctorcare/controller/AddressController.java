package com.dut.doctorcare.controller;

import com.dut.doctorcare.dto.request.AddressCreateRequestDto;
import com.dut.doctorcare.dto.request.AddressUpdateOrDeleteDto;
import com.dut.doctorcare.dto.response.AddressResponseDto;
import com.dut.doctorcare.dto.response.ApiResponse;
import com.dut.doctorcare.service.iface.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @PostMapping
    public ApiResponse<AddressResponseDto> addNewAddress(@PathVariable String userId,
                                                         @RequestBody @Valid AddressCreateRequestDto addressRequest) {
        AddressResponseDto newAddress = addressService.createAddress(userId, addressRequest);
        ApiResponse<AddressResponseDto> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setData(newAddress);
        return response;
    }

    @PutMapping("/{addressId}")
    public ApiResponse<AddressResponseDto> updateAddress(@PathVariable String userId,
                                                         @PathVariable String addressId,
                                                         @RequestBody @Valid AddressUpdateOrDeleteDto addressRequest) {
        AddressResponseDto updatedAddress = addressService.updateAddress(addressId, addressRequest);
        ApiResponse<AddressResponseDto> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setData(updatedAddress);
        return response;
    }

}
