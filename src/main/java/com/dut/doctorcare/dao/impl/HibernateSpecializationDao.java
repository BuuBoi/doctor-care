package com.dut.doctorcare.dao.impl;

import com.dut.doctorcare.dao.AbstractSoftDeleteHibernateDao;
import com.dut.doctorcare.dao.iface.RoleDao;
import com.dut.doctorcare.dao.iface.SpecializationDao;
import com.dut.doctorcare.model.Role;
import com.dut.doctorcare.model.Specialization;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateSpecializationDao extends AbstractSoftDeleteHibernateDao<Specialization> implements SpecializationDao {
    public HibernateSpecializationDao() {
        super(Specialization.class);
    }
    @Override
    public Specialization findByName(String name) {
        Query<Specialization> query = getCurrentSession().createQuery("from Specialization where name = :name", Specialization.class);
        query.setParameter("name", name);
        return query.uniqueResult();
    }
    @Override
    public Specialization save(String specialization) {
        Specialization specialization1 = new Specialization();
        specialization1.setName(specialization);
        return save(specialization1);
    }

}
