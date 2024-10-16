package com.dut.doctorcare.service.iface;

import com.dut.doctorcare.model.Role;

public interface RoleService {
    Role createRole(Role.RoleName roleName);
    Role findRole(Role.RoleName roleName);
}
