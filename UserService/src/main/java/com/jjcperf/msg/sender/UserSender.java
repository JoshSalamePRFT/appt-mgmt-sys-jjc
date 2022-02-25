package com.jjcperf.msg.sender;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.msg.config.JmsConfig;
import com.jjcperf.msg.msg.ResponseMessage;
import com.jjcperf.userservice.controller.UserController;
import com.jjcperf.userservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserController userController;

    //TODO convert RepsonseMessage type to specific message type (e.g. UserGetMessage), as well as in MgmtListener side.

    public void sendGetResponseMessage(long id) {
        User user = userController.getUser(id);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();
        List<User> entities = new ArrayList<User>();
        entities.add(user);
        responseMessage.setEntities(entities);

        System.out.println("Sending a User Get Response!!");
        jmsTemplate.convertAndSend(JmsConfig.USER_GET_SEND_QUEUE, responseMessage);
    }

    public void sendPostResponseMessage (User user) {
        User returnUser = userController.postUser(user);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();

        List<User> entities = new ArrayList<User>();
        entities.add(returnUser);
        responseMessage.setEntities(entities);

        System.out.println("Sending a User Post Response!");
        jmsTemplate.convertAndSend(JmsConfig.USER_POST_SEND_QUEUE, responseMessage);
    }

    public void sendPutResponseMessage(long id, User user) {
        User returnUser = userController.putUser(user, id);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();
        List<User> entities = new ArrayList<User>();
        entities.add(returnUser);
        responseMessage.setEntities(entities);

        System.out.println("Sending a User Put Response!");
        jmsTemplate.convertAndSend(JmsConfig.USER_PUT_SEND_QUEUE, responseMessage);
    }

    public void sendDeleteResponseMessage(long id) {
        userController.deleteUser(id);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();

        System.out.println("Sending a User Delete Response!");
        jmsTemplate.convertAndSend(JmsConfig.USER_DELETE_SEND_QUEUE, responseMessage);
    }

    public void sendGetAllResponseMessage() {
        List<User> userList = userController.getAllUsers();

        ResponseMessage responseMessage = ResponseMessage.builder()
                .id(UUID.randomUUID())
                .build();

        responseMessage.setEntities(userList);

        System.out.println("Sending a User GetAll Response!!");
        jmsTemplate.convertAndSend(JmsConfig.USER_GETALL_SEND_QUEUE, responseMessage);
    }
}
