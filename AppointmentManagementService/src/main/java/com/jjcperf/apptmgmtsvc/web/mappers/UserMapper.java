package com.jjcperf.apptmgmtsvc.web.mappers;

import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.apptmgmtsvc.model.UserDTO;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    UserDTO jsonToDTO(String json);
    UserDTO userToDTO(User user);

    User dtoToUser(UserDTO dto);
}
