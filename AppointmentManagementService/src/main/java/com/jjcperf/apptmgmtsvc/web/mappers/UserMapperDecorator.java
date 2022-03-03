package com.jjcperf.apptmgmtsvc.web.mappers;

import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.apptmgmtsvc.model.UserDTO;
import com.jjcperf.apptmgmtsvc.service.AppointmentManagementService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UserMapperDecorator implements UserMapper {
    private AppointmentManagementService appointmentManagementService;
    private UserMapper mapper;

    @Autowired
    public void setAppointmentManagementService(AppointmentManagementService appointmentManagementService) {
        this.appointmentManagementService = appointmentManagementService;
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDTO userToDTO(User user) {
        return mapper.userToDTO(user);
    }

    @Override
    public User dtoToUser(UserDTO userDTO) {
        return mapper.dtoToUser(userDTO);
    }
}
