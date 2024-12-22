package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.request.SpecializationDto;
import com.dut.doctorcare.model.Specialization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { CustomerMapper.class })
public interface SpecializationMapper {

    @Mapping(target = "id", source = "id", qualifiedByName = "uUIDToString")
    SpecializationDto toSpecializationDto(Specialization specialization);

    @Mapping(target = "id", source = "id", ignore = true)
    Specialization toSpecialization(SpecializationDto specializationDto);
}
