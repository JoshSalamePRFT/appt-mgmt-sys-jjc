package com.jjcperf.msg.sender;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.msg.config.JmsConfig;
import com.jjcperf.msg.enums.CriteriaTypeEnum;
import com.jjcperf.msg.msg.GetMessage;
import com.jjcperf.msg.msg.ResponseMessage;
import com.jjcperf.userservice.model.BaseEntity;
import com.jjcperf.userservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UserSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;


    public void sendUserResponseMessage (long id) {

        User mockUser = User.builder()
                .user_id(1)
                .firstName("Doctor")
                .lastName("Example")
                .gender("Male")
                .age(0)
                .emailAddress("DrExample@test.com")
                .phoneNumber("3016137234")
                .build();

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();
        List<User> entities = new ArrayList<User>();
        entities.add(mockUser);
        responseMessage.setEntities(entities);

        System.out.println("Sending a User Response!!");
        jmsTemplate.convertAndSend(JmsConfig.USER_SEND_QUEUE, responseMessage);
    }
}
