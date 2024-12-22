package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.request.AddressDto;
import com.dut.doctorcare.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = { CustomerMapper.class })
public interface AddressMapper {

     Address toAddress(AddressDto addressDto);

     AddressDto toAddressDto(Address address);

     void updateAddressFromDto(AddressDto addressDto, @MappingTarget Address address);
}
