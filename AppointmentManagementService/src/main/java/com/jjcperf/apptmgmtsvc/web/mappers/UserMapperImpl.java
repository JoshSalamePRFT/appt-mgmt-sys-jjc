package com.jjcperf.apptmgmtsvc.web.mappers;

import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.apptmgmtsvc.model.UserDTO;

public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO jsonToDTO(String json) {
        return null;
    }

    @Override
    public UserDTO userToDTO(User user) {
        return new UserDTO(user.getUser_id(),
                user.getFirstName(),
                user.getLastName(),
                user.getGender(),
                user.getAge(),
                user.getEmailAddress(),
                user.getPhoneNumber(),
                user.getAppointments());
    }

    @Override
    public User dtoToUser(UserDTO dto) {
        return new User(dto.getUser_id(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getGender(),
                dto.getAge(),
                dto.getEmailAddress(),
                dto.getPhoneNumber(),
                dto.getAppointments());
    }
}
