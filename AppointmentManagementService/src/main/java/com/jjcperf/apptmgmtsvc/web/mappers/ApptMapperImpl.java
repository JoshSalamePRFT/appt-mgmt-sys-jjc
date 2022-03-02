package com.jjcperf.apptmgmtsvc.web.mappers;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.AppointmentDTO;
import com.jjcperf.apptmgmtsvc.model.UserDTO;

public class ApptMapperImpl implements ApptMapper {
    @Override
    public AppointmentDTO apptToDTO(Appointment appt) {
        return new AppointmentDTO(appt.getAppointment_id(),
                appt.getApptName(),
                appt.getApptType(),
                appt.getDescription(),
                appt.getStartTime(),
                appt.getEndTime(),
                appt.getMetaData(),
                appt.getUsers()
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
