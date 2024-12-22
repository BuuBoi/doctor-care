package com.dut.doctorcare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DoctorCareApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorCareApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DoctorCareApplication.class, args);
        LOGGER.info("App is working!!");
        System.out.println("\u001B[33m" + "App is working!!" + "\u001B[0m");
        System.out.println("\u001B[32m" + "App is working!!" + "\u001B[0m");
        System.out.println("\u001B[34m" + "App is working!!" + "\u001B[0m");
    }

}
