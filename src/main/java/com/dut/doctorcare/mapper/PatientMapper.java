package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.request.PatientRequest;
import com.dut.doctorcare.dto.response.PatientResponse;
import com.dut.doctorcare.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, CustomeMapper.class})
public interface PatientMapper {
    @Mapping(target = "gender", source = "gender")
    Patient toPatient(PatientRequest patientRequest);

    @Mapping(target = "gender", source = "gender")
    PatientResponse toPatientResponse(Patient patient);

    default Patient.Gender stringToGender(String gender) {
        if (gender != null) {
            return Patient.Gender.valueOf(gender.toUpperCase()); // Chuyển đổi chuỗi thành enum
        }
        return null;
    }

    default String genderToString(Patient.Gender gender) {
        return gender != null ? gender.name() : null; // Chuyển đổi enum thành chuỗi
    }

    void updatePatientFromDto(PatientRequest patientRequest, @MappingTarget Patient patient);
}
