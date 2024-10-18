package com.dut.doctorcare.dao.impl;

import com.dut.doctorcare.dao.AbstractSoftDeleteHibernateDao;
import com.dut.doctorcare.dao.iface.PatientDao;
import com.dut.doctorcare.dao.iface.UserDao;
import com.dut.doctorcare.model.Patient;
import com.dut.doctorcare.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HibernatePatientDao extends AbstractSoftDeleteHibernateDao<Patient> implements PatientDao {

    public HibernatePatientDao() {
        super(Patient.class);
    }
}
