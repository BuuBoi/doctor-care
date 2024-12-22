package com.dut.doctorcare.repositories;

import com.dut.doctorcare.model.Doctor_Day_Offs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsDayOffsRepository extends JpaRepository<Doctor_Day_Offs, Long> {
}
