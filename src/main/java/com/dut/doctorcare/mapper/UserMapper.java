package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.request.UserRegistrationDto;
import com.dut.doctorcare.dto.response.UserResponseDto;
import com.dut.doctorcare.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RoleMapper.class, CustomeMapper.class})
public interface UserMapper {
    @Mapping(target = "passwordHash", source = "password", qualifiedByName = "encodePassword")
    User toUser(UserRegistrationDto userRegistrationDto);
    UserResponseDto toUserResponseDto(User user);
}
