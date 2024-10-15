package com.dut.doctorcare.dao.iface;

import com.dut.doctorcare.dao.iface.common.GenericDao;
import com.dut.doctorcare.dao.iface.common.SoftDeleteDao;
import com.dut.doctorcare.model.Role;

public interface RoleDao extends GenericDao<Role>, SoftDeleteDao<Role> {
    Role createRole(String roleName);
    Role findRole(String roleName);
}
