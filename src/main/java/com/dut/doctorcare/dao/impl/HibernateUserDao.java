package com.dut.doctorcare.dao.impl;

import com.dut.doctorcare.dao.AbstractSoftDeleteHibernateDao;
import com.dut.doctorcare.dao.iface.UserDao;
import com.dut.doctorcare.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HibernateUserDao extends AbstractSoftDeleteHibernateDao<User> implements UserDao {

    public HibernateUserDao() {
        super(User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(getCurrentSession().createQuery("FROM User WHERE email = :email", User.class)
                .setParameter("email", email)
                .uniqueResult());
    }


}
