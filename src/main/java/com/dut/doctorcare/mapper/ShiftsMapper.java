package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.response.ShiftsResponse;
import com.dut.doctorcare.model.Shifts;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomeMapper.class})
public interface ShiftsMapper {
    @Mapping(target = "id", source = "id",  qualifiedByName = "uUIDToString")
    @Mapping(target = "scheduled", ignore = true)
    ShiftsResponse toShiftsResponse(Shifts shifts);
}
