package com.dut.doctorcare.repositories;

import com.dut.doctorcare.model.DoctorDayOffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsDayOffsRepository extends JpaRepository<DoctorDayOffs, Long> {
}
