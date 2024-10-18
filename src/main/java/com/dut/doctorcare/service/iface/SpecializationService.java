package com.dut.doctorcare.service.iface;

import com.dut.doctorcare.dto.request.SpecializationDto;
import com.dut.doctorcare.model.Role;
import com.dut.doctorcare.model.Specialization;

import java.util.List;

public interface SpecializationService {
    SpecializationDto createSpecialization(String specializationName);
    SpecializationDto getSpecializationByName(String name);
    List<SpecializationDto> getAllSpecialization();
    void deleteSpecialization(String id);
}
