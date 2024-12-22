package com.dut.doctorcare.service.iface;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface WeeklyAvailableService {
    void createWeeklyAvailable();
    void updateWeeklyAvailable();
    void deleteWeeklyAvailable();
    Map<String, List<String>> getGroupedWeeklyAvailable(UUID doctorId);
     void updateWeeklySchedule(UUID doctorId, Map<String, List<String>> scheduleMap);
}
