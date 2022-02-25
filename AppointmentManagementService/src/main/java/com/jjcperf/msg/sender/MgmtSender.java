package com.jjcperf.msg.sender;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.msg.config.JmsConfig;
import com.jjcperf.msg.enums.CriteriaTypeEnum;
import com.jjcperf.msg.msg.appt.ApptGetAllMessage;
import com.jjcperf.msg.msg.appt.ApptGetMessage;
import com.jjcperf.msg.msg.appt.ApptPostMessage;
import com.jjcperf.msg.msg.appt.ApptPutMessage;
import com.jjcperf.msg.msg.user.UserGetAllMessage;
import com.jjcperf.msg.msg.user.UserGetMessage;
import com.jjcperf.msg.msg.user.UserPostMessage;
import com.jjcperf.msg.msg.user.UserPutMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class MgmtSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    public void sendUserGetMessage(long id) {
        UserGetMessage message = UserGetMessage
                .builder()
                .id(id)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a User Get Request!")
                .build();

        System.out.println("Sending a User Get Request!");
        jmsTemplate.convertAndSend(JmsConfig.USER_GET_REQ_QUEUE, message);
    }

    public void sendApptGetMessage(long id) {
        ApptGetMessage message = ApptGetMessage
                .builder()
                .id(id)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending an Appt Get Request!")
                .build();

        System.out.println("Sending an Appt Get Request!");
        jmsTemplate.convertAndSend(JmsConfig.APPT_GET_REQ_QUEUE, message);
    }

    public void sendUserPostMessage(User user) {
        UserPostMessage message = UserPostMessage
                .builder()
                .user(user)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a User Post Request!")
                .build();

        System.out.println("Sending a User Post Request!");
        jmsTemplate.convertAndSend(JmsConfig.USER_POST_REQ_QUEUE, message);
    }

    public void sendApptPostMessage(Appointment appt) {
        ApptPostMessage message = ApptPostMessage
                .builder()
                .appt(appt)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a Appt Post Request!")
                .build();

        System.out.println("Sending a Appt Post Request!");
        jmsTemplate.convertAndSend(JmsConfig.APPT_POST_REQ_QUEUE, message);
    }

    public void sendUserPutMessage(long id, User user) {
        UserPutMessage message = UserPutMessage
                .builder()
                .id(id)
                .user(user)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a User Put Request!")
                .build();

        System.out.println("Sending a User Put Request!");
        jmsTemplate.convertAndSend(JmsConfig.USER_PUT_REQ_QUEUE, message);
    }

    public void sendApptPutMessage(long id, Appointment appt) {
        ApptPutMessage message = ApptPutMessage
                .builder()
                .id(id)
                .appt(appt)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending an Appt Put Request!")
                .build();

        System.out.println("Sending an Appt Put Request!");
        jmsTemplate.convertAndSend(JmsConfig.APPT_PUT_REQ_QUEUE, message);
    }

    public void sendUserDeleteMessage(long id) {
        UserGetMessage message = UserGetMessage
                .builder()
                .id(id)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a User Delete Request!")
                .build();

        System.out.println("Sending a User Delete Request!");
        jmsTemplate.convertAndSend(JmsConfig.USER_DELETE_REQ_QUEUE, message);
    }

    public void sendApptDeleteMessage(long id) {
        ApptGetMessage message = ApptGetMessage
                .builder()
                .id(id)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending an Appt Delete Request!")
                .build();

        System.out.println("Sending an Appt Delete Request!");
        jmsTemplate.convertAndSend(JmsConfig.APPT_DELETE_REQ_QUEUE, message);
    }

    @Scheduled(fixedRate = 5000)
    public void sendUserGetAllMessage() {
        UserGetAllMessage message = UserGetAllMessage
                .builder()
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a User Get All Request!")
                .build();

        System.out.println("Sending a User Get All Request!!");
        jmsTemplate.convertAndSend(JmsConfig.USER_GETALL_REQ_QUEUE, message);
    }

    @Scheduled(fixedRate = 5000)
    public void sendApptGetAllMessage() {
        ApptGetAllMessage message = ApptGetAllMessage
                .builder()
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending an Appt Get All Request!")
                .build();

        System.out.println("Sending an Appt Get All Request!!");
        jmsTemplate.convertAndSend(JmsConfig.APPT_GETALL_REQ_QUEUE, message);
    }
}
