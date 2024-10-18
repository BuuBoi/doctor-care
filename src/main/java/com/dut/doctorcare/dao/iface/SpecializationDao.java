package com.dut.doctorcare.dao.iface;

import com.dut.doctorcare.dao.iface.common.GenericDao;
import com.dut.doctorcare.dao.iface.common.SoftDeleteDao;
import com.dut.doctorcare.model.Specialization;

public interface SpecializationDao extends GenericDao<Specialization>, SoftDeleteDao<Specialization> {
    Specialization findByName(String name);
    Specialization save(String specialization);
}
