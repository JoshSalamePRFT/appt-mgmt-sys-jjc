package com.jjcperf.apptmgmtsvc.web.mappers;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.AppointmentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface AppointmentMapper {

    AppointmentDTO apptToDTO(Appointment appointment);

    Appointment dtoToAppt(AppointmentDTO dto);
}
