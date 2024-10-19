package com.dut.doctorcare.dao.impl;

import com.dut.doctorcare.dao.AbstractSoftDeleteHibernateDao;
import com.dut.doctorcare.dao.iface.ShiftsDao;
import com.dut.doctorcare.model.Shifts;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateShiftsDao extends AbstractSoftDeleteHibernateDao<Shifts> implements ShiftsDao {

        public HibernateShiftsDao() {
            super(Shifts.class);
        }
        @Override
        public Shifts findByName(String name) {
            return (Shifts) getCurrentSession().createQuery("from Shifts where shiftName = :name")
                    .setParameter("name", name.toUpperCase())
                    .uniqueResult();
        }
}
