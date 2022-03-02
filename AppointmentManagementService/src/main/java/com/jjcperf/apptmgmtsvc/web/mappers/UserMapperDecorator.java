package com.jjcperf.apptmgmtsvc.web.mappers;

import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.apptmgmtsvc.model.UserDTO;
import com.jjcperf.apptmgmtsvc.service.ApptManagementService;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UserMapperDecorator implements UserMapper {
    private ApptManagementService apptManagementService;
    private UserMapper mapper;

    @Autowired
    public void setApptManagementService(ApptManagementService apptManagementService) {
        this.apptManagementService = apptManagementService;
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDTO userToDTO(User user) {
        UserDTO dto = mapper.userToDTO(user);
        return dto;
    }

    @Override
    public User dtoToUser(UserDTO userDTO) {
        return mapper.dtoToUser(userDTO);
    }
}
