package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.request.PatientDto;
import com.dut.doctorcare.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toEntity(PatientDto patientRequest);

}
