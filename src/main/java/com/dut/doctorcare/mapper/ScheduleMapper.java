package com.dut.doctorcare.mapper;

import com.dut.doctorcare.dto.request.ScheduleRequest;
import com.dut.doctorcare.dto.request.ShiftsRequest;
import com.dut.doctorcare.dto.response.ScheduleResponse;
import com.dut.doctorcare.dto.response.ShiftsResponse;
import com.dut.doctorcare.model.Schedule;
import com.dut.doctorcare.model.Shifts;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomeMapper.class, ShiftsMapper.class})
public interface ScheduleMapper {
//    private String id;
//    private String date;
//    private List<ShiftsRequest> shifts;
//    --------------
//    private LocalDate date;
//    private Schedule.Status status;
//    private Shifts shifts;
    //--------------
//private String id;
//    private String date;
//    private String status;
//    private ShiftsResponse shifts;
    @Mapping(target = "date", source = "date", qualifiedByName = "stringToLocalDate")
    @Mapping(target = "shifts", source = "shifts", ignore = true)
    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "status", ignore = true)
    Schedule toSchedule(ScheduleRequest scheduleRequest);

    @Mapping(target = "id", source = "id", qualifiedByName = "uUIDToString")
    @Mapping(target = "date", source = "date", qualifiedByName = "localDateToString")
    @Mapping(target = "status", source = "status", qualifiedByName = "statusToString")
    ScheduleResponse toScheduleResponse(Schedule schedule);
}
