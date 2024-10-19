package com.dut.doctorcare.service.impl;

import com.dut.doctorcare.dao.iface.ShiftsDao;
import com.dut.doctorcare.dto.response.ShiftsResponse;
import com.dut.doctorcare.exception.AppException;
import com.dut.doctorcare.exception.EntityOperationException;
import com.dut.doctorcare.exception.ErrorCode;
import com.dut.doctorcare.mapper.ShiftsMapper;
import com.dut.doctorcare.model.Shifts;
import com.dut.doctorcare.service.iface.ShiftsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ShiftsServiceImpl implements ShiftsService {
    private final ShiftsDao shiftsDao;
    private final ShiftsMapper shiftsMapper;

    @Override
    public ShiftsResponse createShifts(String name) {
        String name1 = name.toUpperCase();
        Shifts shifts;
        if (shiftsDao.findByName(name1) != null) {
            log.error("Shifts with name {} already exists", name1);
            throw new AppException(ErrorCode.Email_ALREADY_EXISTS);
        }
        shifts = Shifts.builder().shiftName(name1).build();
        ShiftsResponse shiftsResponse = shiftsMapper.toShiftsResponse(shiftsDao.save(shifts));
        return shiftsResponse;
    }

    @Override
    public List<ShiftsResponse> getAllShifts() {
        Map<String, Object> predicate = new HashMap<>();
        List<Shifts> shifts = shiftsDao.findAll(predicate);
        return shifts.stream().map(shiftsMapper::toShiftsResponse).toList();
    }

    @Override
    public void deleteShifts(String id) {
        try {
            Shifts shifts = shiftsDao.findById(UUID.fromString(id)).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
            shiftsDao.softDelete(shifts.getId());
        }
        catch (EntityOperationException e) {
            throw new AppException(ErrorCode.DATABASE_OPERATION_FAILED);
        }
    }
}
