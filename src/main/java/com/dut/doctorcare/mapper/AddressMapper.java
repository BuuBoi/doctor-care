package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.request.AddressDto;
import com.dut.doctorcare.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomeMapper.class})
public interface AddressMapper {

     Address toAddress(AddressDto addressDto);
     AddressDto toAddressDto(Address address);
}