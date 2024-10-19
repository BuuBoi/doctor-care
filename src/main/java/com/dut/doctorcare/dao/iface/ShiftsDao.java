package com.dut.doctorcare.dao.iface;

import com.dut.doctorcare.dao.iface.common.GenericDao;
import com.dut.doctorcare.dao.iface.common.SoftDeleteDao;
import com.dut.doctorcare.model.Role;
import com.dut.doctorcare.model.Shifts;

public interface ShiftsDao extends GenericDao<Shifts>, SoftDeleteDao<Shifts> {
    Shifts findByName(String name);
}
