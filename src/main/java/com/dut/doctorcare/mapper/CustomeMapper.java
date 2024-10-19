package com.dut.doctorcare.mapper;

import com.dut.doctorcare.model.Patient;
import com.dut.doctorcare.model.Role;
import com.dut.doctorcare.model.Schedule;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class CustomeMapper {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Named("encodePassword")
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Named("stringToUUID")
    public UUID stringToUUID(String uuid) {
        return UUID.fromString(uuid);
    }

    @Named("uUIDToString")
    public String uUIDToString(UUID uuid) {
        return uuid.toString();
    }

    @Named("stringToGender")
    public Patient.Gender stringToGender(String gender) {
        return Patient.Gender.valueOf(gender.toUpperCase());
    }

    @Named("genderToString")
    public String genderToString(Patient.Gender gender) {
        return gender.name();
    }

    @Named("stringToLocalDate")
    public LocalDate stringToLocalDate(String date) {
        return LocalDate.parse(date, formatter);
    }

    @Named("localDateToString")
    public String localDateToString(LocalDate date) {
        return date.format(formatter);
    }

    // Phương thức ánh xạ tùy chỉnh từ String -> Enum
    @Named("stringToRole")
    public Role.RoleName stringToRole(String role) {
        return Role.RoleName.valueOf(role.toUpperCase());
    }

    // Phương thức ánh xạ tùy chỉnh từ Enum -> String nếu cần ngược lại
    @Named("roleToString")
    public String roleToString(Role.RoleName role) {
        return role.name();
    }

    @Named("statusToString")
    public String statusToString(Schedule.Status status) {
        return status.name();
    }

}
