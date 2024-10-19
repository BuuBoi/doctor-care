package com.dut.doctorcare.dao.iface;

import com.dut.doctorcare.dao.iface.common.GenericDao;
import com.dut.doctorcare.dao.iface.common.SoftDeleteDao;
import com.dut.doctorcare.model.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleDao extends GenericDao<Schedule>, SoftDeleteDao<Schedule> {
    List<Schedule> findAllExpiredSchedules(LocalDate today);
}
