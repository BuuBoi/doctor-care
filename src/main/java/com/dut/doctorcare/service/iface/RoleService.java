package com.dut.doctorcare.service.iface;

import com.dut.doctorcare.model.Role;

public interface RoleService {
    Role createRole(String roleName);
    Role findRole(String roleName);
}
