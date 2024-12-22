package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.response.RoleResponse;
import com.dut.doctorcare.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { CustomerMapper.class })
public interface RoleMapper {
    @Mapping(target = "roleName", source = "roleName", qualifiedByName = "roleToString")
    RoleResponse toRoleResponse(Role role);
}
