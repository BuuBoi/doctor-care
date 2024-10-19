package com.dut.doctorcare.service.iface;

import com.dut.doctorcare.dto.response.ShiftsResponse;

import java.util.List;

public interface ShiftsService {
    ShiftsResponse createShifts(String name);
    List<ShiftsResponse> getAllShifts();
    void deleteShifts(String id);
}
