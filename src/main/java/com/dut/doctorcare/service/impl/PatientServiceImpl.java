package com.dut.doctorcare.service.impl;

import com.dut.doctorcare.dao.iface.AddressDao;
import com.dut.doctorcare.dao.iface.PatientDao;
import com.dut.doctorcare.dao.iface.UserDao;
import com.dut.doctorcare.dto.request.AddressDto;
import com.dut.doctorcare.dto.request.PatientRequest;
import com.dut.doctorcare.dto.response.PatientResponse;
import com.dut.doctorcare.exception.AppException;
import com.dut.doctorcare.exception.ErrorCode;
import com.dut.doctorcare.mapper.AddressMapper;
import com.dut.doctorcare.mapper.PatientMapper;
import com.dut.doctorcare.model.Address;
import com.dut.doctorcare.model.Patient;
import com.dut.doctorcare.model.User;
import com.dut.doctorcare.service.iface.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
        private final PatientDao patientDao;
        private final PatientMapper patientMapper;
        private final AddressMapper addressMapper;
        private  final AddressDao addressDao;
        private final UserDao userDao;
        @Override
        public PatientResponse saveOrUpdate(PatientRequest patientRequest) {
            var context = SecurityContextHolder.getContext();
            var email = context.getAuthentication().getName();
            User user = userDao.findByEmail(email).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
            Patient patient = null;
                if(patientRequest.getId() == null || patientRequest.getId().isEmpty()) {
                    patient =  patientMapper.toPatient(patientRequest);
                    AddressDto addressDto = patientRequest.getAddressDto();
                    Address address = addressDao.save(addressMapper.toAddress(addressDto));
                    patient.setAddress(address);
                    patient.setUser(user);
                    patientDao.save(patient);
                }else {
                    patient = patientDao.findById(UUID.fromString(patientRequest.getId()))
                            .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
                    patientMapper.updatePatientFromDto(patientRequest, patient);
                    Address address = patient.getAddress();
                    if(address.getProvince().equals(patientRequest.getAddressDto().getProvince())  ||
                            address.getDistrict().equals(patientRequest.getAddressDto().getDistrict()) ||
                            address.getWard().equals(patientRequest.getAddressDto().getWard()) ||
                            address.getDetails().equals(patientRequest.getAddressDto().getDetails())) {
                       address = addressDao.update(addressMapper.toAddress(patientRequest.getAddressDto()));
                        patient.setAddress(address);
                        patientDao.update(patient);
                    }
                }

                return patientMapper.toPatientResponse(patient);
        }

}
