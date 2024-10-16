package com.dut.doctorcare.dao.iface;

import com.dut.doctorcare.dao.iface.common.GenericDao;
import com.dut.doctorcare.dao.iface.common.SoftDeleteDao;
import com.dut.doctorcare.model.Role;

public interface RoleDao extends GenericDao<Role>, SoftDeleteDao<Role> {
    Role createRole(Role.RoleName roleName);
    Role findRole(Role.RoleName roleName);
}
