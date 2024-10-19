package com.dut.doctorcare.dao.impl;

import com.dut.doctorcare.dao.AbstractSoftDeleteHibernateDao;
import com.dut.doctorcare.dao.iface.ScheduleDao;
import com.dut.doctorcare.model.Schedule;
import com.dut.doctorcare.model.Shifts;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class HibernateScheduleDao extends AbstractSoftDeleteHibernateDao<Schedule> implements ScheduleDao {
    public HibernateScheduleDao() {
        super(Schedule.class);
    }

}
