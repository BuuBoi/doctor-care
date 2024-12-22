package com.dut.doctorcare.dao.iface;

import com.dut.doctorcare.dao.iface.common.GenericDao;
import com.dut.doctorcare.dao.iface.common.SoftDeleteDao;
import com.dut.doctorcare.model.Doctor;

public interface DoctorDao extends GenericDao<Doctor>, SoftDeleteDao<Doctor> {
    Doctor saveOrUpdate(Doctor doctor);
}
