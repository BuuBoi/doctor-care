package com.dut.doctorcare.repositories;

import com.dut.doctorcare.model.WeeklyAvailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface WeeklyAvailableRepository extends JpaRepository<WeeklyAvailable, Long> {

    /**
     * Xóa tất cả lịch khám của một bác sĩ.
     *
     * @param doctorId UUID của bác sĩ.
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM WeeklyAvailable w WHERE w.doctor.id = :doctorId")
    void deleteByDoctorId(@Param("doctorId") UUID doctorId);

    /**
     * Lấy tất cả lịch khám của một bác sĩ.
     *
     * @param doctorId UUID của bác sĩ.
     * @return Danh sách lịch khám.
     */
    @Query("SELECT w FROM WeeklyAvailable w WHERE w.doctor.id = :doctorId")
    List<WeeklyAvailable> findByDoctorId(@Param("doctorId") UUID doctorId);
}