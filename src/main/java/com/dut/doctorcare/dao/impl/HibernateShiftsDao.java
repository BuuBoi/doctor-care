package com.dut.doctorcare.dao.impl;

import com.dut.doctorcare.dao.AbstractSoftDeleteHibernateDao;
import com.dut.doctorcare.dao.iface.ShiftsDao;
import com.dut.doctorcare.model.Shifts;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class HibernateShiftsDao extends AbstractSoftDeleteHibernateDao<Shifts> implements ShiftsDao {

        public HibernateShiftsDao() {
            super(Shifts.class);
        }
        @Override
        public Shifts findByName(String name) {
            return (Shifts) getCurrentSession().createQuery("from Shifts where shiftName = :name", Shifts.class)
                    .setParameter("name", name.toUpperCase())
                    .uniqueResult();
        }
        @Override
        public List<Shifts> findAllByIds(List<UUID> ids) {
            return getCurrentSession().createQuery("from Shifts where id in :ids", Shifts.class)
                    .setParameterList("ids", ids)
                    .getResultList();
        }

}
