package com.dut.doctorcare.service.iface;

import com.dut.doctorcare.dto.request.PatientRequest;
import com.dut.doctorcare.dto.response.PatientResponse;
import com.dut.doctorcare.exception.EntityOperationException;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    PatientResponse saveOrUpdate(PatientRequest patientRequest);
    PatientResponse getMyInfo();
    List<PatientResponse> getPatients();
    PatientResponse getPatientById(String patientId);
    void deletePatient(String patientId) throws EntityOperationException;
}
