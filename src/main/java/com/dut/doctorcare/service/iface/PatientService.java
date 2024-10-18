package com.dut.doctorcare.service.iface;

import com.dut.doctorcare.dto.request.PatientRequest;
import com.dut.doctorcare.dto.response.PatientResponse;

public interface PatientService {
    PatientResponse saveOrUpdate(PatientRequest patientRequest);
    PatientResponse getMyInfo();
}
