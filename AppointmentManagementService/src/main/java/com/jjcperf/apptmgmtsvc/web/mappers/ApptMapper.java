package com.jjcperf.apptmgmtsvc.web.mappers;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.AppointmentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ApptMapper {

    public AppointmentDTO apptToDTO(Appointment appt);

    public Appointment dtoToAppt(AppointmentDTO dto);
}
