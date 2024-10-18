package com.dut.doctorcare.service.impl;

import com.dut.doctorcare.dao.iface.SpecializationDao;
import com.dut.doctorcare.dto.request.SpecializationDto;
import com.dut.doctorcare.exception.AppException;
import com.dut.doctorcare.exception.ErrorCode;
import com.dut.doctorcare.mapper.SpecializationMapper;
import com.dut.doctorcare.model.Specialization;
import com.dut.doctorcare.service.iface.SpecializationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SpecializationServiceImpl implements SpecializationService {
    private final SpecializationDao specializationDao;
    private final SpecializationMapper specializationMapper;
    @Override
    public SpecializationDto createSpecialization(String specialization) {
        return specializationMapper.toSpecializationDto(specializationDao.save(specialization));
    }

    @Override
    public SpecializationDto getSpecializationByName(String name) {
        return specializationMapper.toSpecializationDto(specializationDao.findByName(name));
    }

    @Override
    public List<SpecializationDto> getAllSpecialization() {
        Map<String, Object> params = new HashMap<>();
        List<Specialization> specializations = specializationDao.findAll(params);
        return specializations.stream().map(specializationMapper::toSpecializationDto).collect(Collectors.toList());
    }
    @Override
    public void deleteSpecialization(String id) {
        try {
            Specialization specialization = specializationDao.findById(UUID.fromString(id)).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
            specializationDao.softDelete(specialization.getId());
        } catch (Exception e) {
            throw new AppException(ErrorCode.DATABASE_OPERATION_FAILED);
        }
    }
}
