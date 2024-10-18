package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.response.RoleResponse;
import com.dut.doctorcare.model.Role;
import com.dut.doctorcare.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.dut.doctorcare.mapper.CustomeMapper;


@Mapper(componentModel = "spring", uses = {CustomeMapper.class})
public interface RoleMapper {
    @Mapping(target = "roleName", source = "roleName", qualifiedByName = "roleToString")
    RoleResponse toRoleResponse(Role role);
}
