package com.dut.doctorcare.config;

import com.dut.doctorcare.dao.iface.RoleDao;
import com.dut.doctorcare.dao.iface.UserDao;
import com.dut.doctorcare.model.Role;
import com.dut.doctorcare.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class ApplicationStartup {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void createAdminUser() {
        if (userDao.findByEmail("admin888@gmail.com").isEmpty()) {
            Role adminRole = roleDao.findRole(Role.RoleName.ADMIN);
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setRoleName(Role.RoleName.ADMIN);
                adminRole = roleDao.save(adminRole);
                log.info("Admin role created");
            }

            User adminUser = new User();
            adminUser.setEmail("admin888@gmail.com");
            adminUser.setPasswordHash(passwordEncoder.encode("admin888"));
            adminUser.setFullName("Admin888");
            adminUser.setRole(adminRole);
            userDao.save(adminUser);
            log.info("Admin user created");
        } else {
            log.info("Admin user already exists");
        }
    }
}
