package com.dut.doctorcare.service.impl;

import com.dut.doctorcare.dao.iface.ScheduleDao;
import com.dut.doctorcare.dao.iface.ShiftsDao;
import com.dut.doctorcare.dao.iface.UserDao;
import com.dut.doctorcare.dto.request.ScheduleRequest;
import com.dut.doctorcare.dto.request.ShiftsRequest;
import com.dut.doctorcare.dto.response.ScheduleResponse;
import com.dut.doctorcare.exception.AppException;
import com.dut.doctorcare.exception.ErrorCode;
import com.dut.doctorcare.mapper.ScheduleMapper;
import com.dut.doctorcare.mapper.ShiftsMapper;
import com.dut.doctorcare.model.Doctor;
import com.dut.doctorcare.model.Schedule;
import com.dut.doctorcare.model.Shifts;
import com.dut.doctorcare.model.User;
import com.dut.doctorcare.service.iface.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleDao scheduleDao;
    private final ShiftsDao shiftsDao;
    private final ScheduleMapper scheduleMapper;
    private final ShiftsMapper shiftsMapper;
    private final UserDao userDao;

    @Override
    public List<ScheduleResponse> createSchedule(ScheduleRequest request) {
        var context = SecurityContextHolder.getContext();
        User user = userDao.findByEmail(context.getAuthentication().getName()).orElseThrow(() ->new AppException(ErrorCode.USER_NOT_FOUND));
        Doctor doctor = user.getDoctor();
        Schedule schedule = scheduleMapper.toSchedule(request);
        List<UUID> IdShifts = request.getShifts().stream().map(ShiftsRequest::getId).map(UUID::fromString).toList();
        List<Shifts> shifts = shiftsDao.findAllByIds(IdShifts);
        List<ScheduleResponse> schedules = shifts.stream().map(shift ->{
            schedule.setShifts(shift);
            schedule.setStatus(Schedule.Status.EMPTY);
            schedule.setDoctor(doctor);
            return scheduleDao.save(schedule);
        }).toList().stream().map(scheduleMapper::toScheduleResponse).toList();

        return schedules;
    }
}
