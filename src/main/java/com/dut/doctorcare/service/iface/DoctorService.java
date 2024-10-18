package com.dut.doctorcare.service.iface;

import com.dut.doctorcare.dto.request.DoctorRequest;
import com.dut.doctorcare.dto.request.PatientRequest;
import com.dut.doctorcare.dto.response.DoctorResponse;
import com.dut.doctorcare.dto.response.PatientResponse;

public interface DoctorService {
    DoctorResponse saveOrUpdate(DoctorRequest request);
    DoctorResponse getMyInfo();
}
