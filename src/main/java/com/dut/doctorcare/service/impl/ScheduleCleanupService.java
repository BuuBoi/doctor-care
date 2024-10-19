package com.dut.doctorcare.service.impl;

import com.dut.doctorcare.dao.iface.ScheduleDao;
import com.dut.doctorcare.model.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleCleanupService {
    private final ScheduleDao scheduleDao;
    @Scheduled(cron = "0 0 0 * * ?")
    public void removeExpiredSchedules() {
        LocalDate today = LocalDate.now();
        List<Schedule> expiredSchedules = scheduleDao.findAllExpiredSchedules(today);
        for (Schedule schedule : expiredSchedules) {
            scheduleDao.delete(schedule);
        }
    }
}
