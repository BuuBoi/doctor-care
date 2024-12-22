package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.request.DoctorRequest;
import com.dut.doctorcare.dto.response.DoctorResponse;
import com.dut.doctorcare.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = { AddressMapper.class, CustomerMapper.class, SpecializationMapper.class })
public interface DoctorMapper {
    @Mapping(target = "id", ignore = true) // Bỏ qua trường id khi mapping
    @Mapping(target = "gender", source = "gender", qualifiedByName = "stringToGender")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", qualifiedByName = "stringToLocalDate")
    @Mapping(target = "address", source = "addressDto", ignore = true)
    @Mapping(target = "specialization", ignore = true)
    @Mapping(target = "phone", source = "phoneNumber")
    Doctor toDoctor(DoctorRequest doctorRequest);

    @Mapping(target = "gender", source = "gender", qualifiedByName = "genderToString")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", qualifiedByName = "localDateToString")
    @Mapping(target = "addressDto", source = "address")
    @Mapping(target = "specializationDto", source = "specialization")
    @Mapping(target = "phoneNumber", source = "phone")
    DoctorResponse toDoctorResponse(Doctor doctor);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "specialization", ignore = true)
    @Mapping(target = "gender", source = "gender", qualifiedByName = "stringToGender")
    @Mapping(target = "phone", source = "phoneNumber")
    void updateDoctorFromDto(DoctorRequest doctorRequest, @MappingTarget Doctor doctor);
}
