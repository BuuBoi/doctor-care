package com.dut.doctorcare.controller;

import com.dut.doctorcare.dto.request.PatientRequest;
import com.dut.doctorcare.dto.response.ApiResponse;
import com.dut.doctorcare.dto.response.PatientResponse;
import com.dut.doctorcare.service.iface.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    @RequestMapping("/profile")
    public ApiResponse<PatientResponse> addPatientProfile(@RequestBody PatientRequest patientRequest) {
        PatientResponse patientResponse = patientService.saveOrUpdate(patientRequest);
        return ApiResponse.<PatientResponse>builder()
                .status(200)
                .data(patientResponse)
                .build();
    }
    @GetMapping("/profile")
    public ApiResponse<PatientResponse> getMyInfo(){
        PatientResponse patientResponse = patientService.getMyInfo();
        return ApiResponse.<PatientResponse>builder()
                .status(200)
                .data(patientResponse)
                .build();
    }

//    @PutMapping("/{patientId}")
//    public ApiResponse<PatientResponse> updatePatient(@PathVariable String patientId, @RequestBody PatientRequest patientRequest) {
//        PatientResponse patientResponse = patientService.saveOrUpdate(patientId, patientRequest);
//        return ApiResponse.<PatientResponse>builder()
//                .status(200)
//                .data(patientResponse)
//                .build();
//    }
//
//    @GetMapping("/{patientId}")
//    public ApiResponse<PatientResponse> getPatient(@PathVariable String patientId) {
//        PatientResponse patientResponse = patientService.getPatientById(patientId);
//        return ApiResponse.<PatientResponse>builder()
//                .status(200)
//                .data(patientResponse)
//                .build();
//    }
//
//    @GetMapping
//    public ApiResponse<PatientResponse> getPatients() {
//        PatientResponse patientResponse = patientService.getPatients();
//        return ApiResponse.<PatientResponse>builder()
//                .status(200)
//                .data(patientResponse)
//                .build();
//    }
}
