package com.dut.doctorcare.dao.iface;

import com.dut.doctorcare.dao.iface.common.GenericDao;
import com.dut.doctorcare.dao.iface.common.SoftDeleteDao;
import com.dut.doctorcare.model.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User>, SoftDeleteDao<User> {
    Optional<User> findByEmail(String email);
}
