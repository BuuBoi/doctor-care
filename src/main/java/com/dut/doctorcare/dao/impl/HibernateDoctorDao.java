package com.dut.doctorcare.dao.impl;

import com.dut.doctorcare.dao.AbstractSoftDeleteHibernateDao;
import com.dut.doctorcare.dao.iface.DoctorDao;
import com.dut.doctorcare.dao.iface.PatientDao;
import com.dut.doctorcare.model.Doctor;
import com.dut.doctorcare.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDoctorDao extends AbstractSoftDeleteHibernateDao<Doctor> implements DoctorDao {

    public HibernateDoctorDao() {
        super(Doctor.class);
    }

    @Override
    public Doctor saveOrUpdate(Doctor doctor) {
        if(doctor.getId() == null) {
            return save(doctor);
        } else {
            return update(doctor);
        }

    }

}
