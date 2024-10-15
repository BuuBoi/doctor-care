package com.dut.doctorcare.service.impl;

import com.dut.doctorcare.dao.iface.RoleDao;
import com.dut.doctorcare.model.Role;
import com.dut.doctorcare.service.iface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role createRole(String roleName) {
       return roleDao.createRole(roleName);
    }

    @Override
    public Role findRole(String roleName) {
        return roleDao.findRole(roleName);
    }


}