package com.jjcperf.apptmgmtsvc.web.mappers;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.AppointmentDTO;

public class AppointmentMapperImpl implements AppointmentMapper {
    @Override
    public AppointmentDTO apptToDTO(Appointment appointment) {
        return new AppointmentDTO(appointment.getAppointment_id(),
                appointment.getApptName(),
                appointment.getApptType(),
                appointment.getDescription(),
                appointment.getStartTime(),
                appointment.getEndTime(),
                appointment.getMetaData(),
                appointment.getUsers()
        );
    }

    @Override
    public Appointment dtoToAppt(AppointmentDTO dto) {

        return new Appointment(dto.getAppointment_id(),
                dto.getApptName(),
                dto.getApptType(),
                dto.getDescription(),
                dto.getStartTime(),
                dto.getEndTime(),
                dto.getMetaData(),
                dto.getUsers()
        );
    }
}
