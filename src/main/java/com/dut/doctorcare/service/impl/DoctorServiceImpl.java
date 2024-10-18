package com.dut.doctorcare.service.impl;

import com.dut.doctorcare.dao.iface.AddressDao;
import com.dut.doctorcare.dao.iface.DoctorDao;
import com.dut.doctorcare.dao.iface.UserDao;
import com.dut.doctorcare.dto.request.DoctorRequest;
import com.dut.doctorcare.dto.response.DoctorResponse;
import com.dut.doctorcare.exception.AppException;
import com.dut.doctorcare.exception.ErrorCode;
import com.dut.doctorcare.mapper.AddressMapper;
import com.dut.doctorcare.mapper.DoctorMapper;
import com.dut.doctorcare.mapper.SpecializationMapper;
import com.dut.doctorcare.model.Address;
import com.dut.doctorcare.model.Doctor;
import com.dut.doctorcare.model.Specialization;
import com.dut.doctorcare.model.User;
import com.dut.doctorcare.service.iface.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    private final DoctorDao doctorDao;
    private final DoctorMapper doctorMapper;
    private final AddressMapper addressMapper;
    private final SpecializationMapper specializationMapper;
    private final AddressDao addressDao;
    private final UserDao userDao;
    public DoctorResponse saveOrUpdate(DoctorRequest request) {
        var context = SecurityContextHolder.getContext();
        var email = context.getAuthentication().getName();
        User user = userDao.findByEmail(email).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        Doctor doctor = doctorDao.findById(user.getId()).orElse(null);
        if(doctor == null) {
            doctor = doctorMapper.toDoctor(request);
            Address address = addressDao.save(addressMapper.toAddress(request.getAddressDto()));
            Specialization specialization = specializationMapper.toSpecialization(request.getSpecializationDto());

            doctor = doctorMapper.toDoctor(request);
            doctor.setAddress(address);
            doctor.setUser(user);
            return doctorMapper.toDoctorResponse(doctorDao.save(doctor));
        } else {
            doctorMapper.updateDoctorFromDto(request, doctor);
            return doctorMapper.toDoctorResponse(doctorDao.update(doctor));
        }
    }

    public DoctorResponse getMyInfo() {
        return null;
    }
}
