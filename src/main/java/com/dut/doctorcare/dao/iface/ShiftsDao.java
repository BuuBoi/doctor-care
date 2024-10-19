package com.dut.doctorcare.dao.iface;

import com.dut.doctorcare.dao.iface.common.GenericDao;
import com.dut.doctorcare.dao.iface.common.SoftDeleteDao;
import com.dut.doctorcare.model.Role;
import com.dut.doctorcare.model.Shifts;

import java.util.List;
import java.util.UUID;

public interface ShiftsDao extends GenericDao<Shifts>, SoftDeleteDao<Shifts> {
    Shifts findByName(String name);
    List<Shifts> findAllByIds(List<UUID> ids);
}
