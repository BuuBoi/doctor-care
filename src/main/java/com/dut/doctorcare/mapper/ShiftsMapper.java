package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.request.ShiftsRequest;
import com.dut.doctorcare.dto.response.ShiftsResponse;
import com.dut.doctorcare.model.Shifts;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomeMapper.class})
public interface ShiftsMapper {
    @Mapping(target = "id", source = "id",  qualifiedByName = "uUIDToString")
    @Mapping(target = "scheduled", ignore = true)
    @Mapping(target = "hasAppointment", ignore = true)
    ShiftsResponse toShiftsResponse(Shifts shifts);

    @Mapping(target = "id", source = "id",  qualifiedByName = "stringToUUID")
    Shifts toShifts(ShiftsRequest shiftsRequest);
}
