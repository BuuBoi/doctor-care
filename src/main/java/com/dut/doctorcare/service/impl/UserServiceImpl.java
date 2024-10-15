package com.dut.doctorcare.service.impl;

import com.dut.doctorcare.dao.iface.UserDao;
import com.dut.doctorcare.dto.request.PasswordChangeDto;
import com.dut.doctorcare.dto.request.UserRegistrationDto;
import com.dut.doctorcare.dto.request.UserUpdateOrDeleteDto;
import com.dut.doctorcare.dto.response.UserResponseDto;
import com.dut.doctorcare.exception.AppException;
import com.dut.doctorcare.exception.EntityOperationException;
import com.dut.doctorcare.exception.ErrorCode;
import com.dut.doctorcare.model.Role;
import com.dut.doctorcare.model.User;
import com.dut.doctorcare.service.iface.RoleService;
import com.dut.doctorcare.service.iface.UserService;
import com.dut.doctorcare.utils.UserUtils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;
    }

    @Override
    public UserResponseDto addUser(UserRegistrationDto userRegistrationDto) {
        if (userDao.findByEmail(userRegistrationDto.getEmail()).isPresent()) {
            throw new AppException(ErrorCode.Email_ALREADY_EXISTS);
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);


        User user = new User();
        user.setEmail(userRegistrationDto.getEmail());
        user.setPasswordHash(passwordEncoder.encode(userRegistrationDto.getPassword()));
        System.out.println("Password: " + passwordEncoder.encode(userRegistrationDto.getPassword()));
//        user.setDisplayName(userRegistrationDto.getDisplayName());
//        user.setAvatarUrl(userRegistrationDto.getAvatarUrl());
//        user.setPhoneNumber(userRegistrationDto.getPhoneNumber());
        //user.setPaymentInformation(userRegistrationDto.getPaymentInformation());
        //user.setVerified(false); // Mặc định người dùng chưa được xác thực
        Role role = roleService.findRole("AA");

        if (role == null) {
            role = roleService.createRole("AA");
        }
        user.setRole(role); // Thiết lập vai trò mặc định


        user = userDao.save(user);
        return UserUtils.convertToDTO(user);

    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponseDto> getAllUsers() {
        log.info("Not into this method if not admin");
        return userDao.findAll(Collections.emptyMap()).stream().map(UserUtils::convertToDTO).collect(Collectors.toList());
    }

    @PostAuthorize("returnObject.email == authentication.getName() || hasRole('ADMIN')")
    @Override
    public UserResponseDto getUser(String id) {
        User user = userDao.findById(UUID.fromString(id)).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        return UserUtils.convertToDTO(user);
    }

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Override
    @Transactional
    public UserResponseDto updateUser(String id, UserUpdateOrDeleteDto userUpdateOrDeleteDto) {
        logger.info("Updating user in service layer. ID: {}", id);
        return userDao.findById(UUID.fromString(id)).map(user -> {
            logger.debug("Found user: {}", user);
            User savedUser = userDao.save(user);
            logger.info("User saved to database: {}", savedUser);
            return UserUtils.convertToDTO(savedUser);

        }).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
    }
    @Transactional
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(String id) throws EntityOperationException {
        User user = userDao.findById(UUID.fromString(id)).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        user.setActive(false);
        userDao.update(user);
    }

    @Transactional
    @Override
    public UserResponseDto getMyProfile() {
        var context = SecurityContextHolder.getContext();
        var email = context.getAuthentication().getName();
        User user = userDao.findByEmail(email).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        return UserUtils.convertToDTO(user);
    }

    @Transactional
    public void changePassword(String userId, PasswordChangeDto passwordChangeDto) {
        User user = userDao.findById(UUID.fromString(userId))
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        // Verify current password
        if (!user.getPasswordHash().equals(passwordChangeDto.getCurrentPassword())) {
            throw new AppException(ErrorCode.INVALID_CURRENT_PASSWORD);
        }

        // Check if new password and confirm password match
        if (!passwordChangeDto.getNewPassword().equals(passwordChangeDto.getConfirmPassword())) {
            throw new AppException(ErrorCode.PASSWORD_MISMATCH);
        }

        // Encode and set new password
        user.setPasswordHash(passwordChangeDto.getNewPassword());
        userDao.save(user);
    }
}
