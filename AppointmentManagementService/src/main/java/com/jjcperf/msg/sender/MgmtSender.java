package com.jjcperf.msg.sender;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.msg.config.JmsConfig;
import com.jjcperf.msg.enums.CriteriaTypeEnum;
import com.jjcperf.msg.msg.ResponseMessage;
import com.jjcperf.msg.msg.appt.ApptGetAllMessage;
import com.jjcperf.msg.msg.appt.ApptGetMessage;
import com.jjcperf.msg.msg.appt.ApptPostMessage;
import com.jjcperf.msg.msg.appt.ApptPutMessage;
import com.jjcperf.msg.msg.user.UserGetAllMessage;
import com.jjcperf.msg.msg.user.UserGetMessage;
import com.jjcperf.msg.msg.user.UserPostMessage;
import com.jjcperf.msg.msg.user.UserPutMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@RequiredArgsConstructor
@Component
@Slf4j
public class MgmtSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    public Message sendUserGetMessage(long id) {
        UserGetMessage message = UserGetMessage
                .builder()
                .id(id)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a User Get Request!")
                .build();

        log.debug("Sending a User Get Request!");

        Message responseMessage = sendAndReceiveMessage(JmsConfig.USER_GET_QUEUE,
                "com/jjcperf/msg/msg/user/UserGetMessage.java", message);

        log.debug("I Got a User Get Response!" + responseMessage);

        return responseMessage;
    }

    public Message sendAppointmentGetMessage(long id) {
        ApptGetMessage message = ApptGetMessage
                .builder()
                .id(id)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending an Appt Get Request!")
                .build();

        log.debug("Sending an Appt Get Request!");

        Message responseMessage = sendAndReceiveMessage(JmsConfig.APPT_GET_QUEUE,
                "com/jjcperf/msg/msg/appt/ApptGetMessage.java", message);

        log.debug("I Got an Appointment Get Response!" + responseMessage);

        return responseMessage;
    }

    public Message sendUserPostMessage(User user) {
        UserPostMessage message = UserPostMessage
                .builder()
                .user(user)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a User Post Request!")
                .build();

        log.debug("Sending a User Post Request!");

        Message responseMessage = sendAndReceiveMessage(JmsConfig.USER_POST_QUEUE,
                "com/jjcperf/msg/msg/user/UserPostMessage.java", message);

        log.debug("I Got a User Post Response!" + responseMessage);

        return responseMessage;
    }

    public Message sendAppointmentPostMessage(Appointment appt) {
        ApptPostMessage message = ApptPostMessage
                .builder()
                .appt(appt)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a Appt Post Request!")
                .build();

        log.debug("Sending an Appt Post Request!");

        Message responseMessage = sendAndReceiveMessage(JmsConfig.APPT_POST_QUEUE,
                "com/jjcperf/msg/msg/appt/ApptPostMessage.java", message);

        log.debug("I Got an Appointment Post Response!" + responseMessage);

        return responseMessage;
    }

    public Message sendUserPutMessage(long id, User user) {
        UserPutMessage message = UserPutMessage
                .builder()
                .id(id)
                .user(user)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a User Put Request!")
                .build();

        log.debug("Sending a User Put Request!");

        Message responseMessage = sendAndReceiveMessage(JmsConfig.USER_PUT_QUEUE,
                "com/jjcperf/msg/msg/user/UserPutMessage.java", message);

        log.debug("I Got a User Put Response!" + responseMessage);

        return responseMessage;
    }

    public Message sendAppointmentPutMessage(long id, Appointment appt) {
        ApptPutMessage message = ApptPutMessage
                .builder()
                .id(id)
                .appt(appt)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending an Appt Put Request!")
                .build();

        log.debug("Sending an Appt Put Request!");

        Message responseMessage = sendAndReceiveMessage(JmsConfig.APPT_PUT_QUEUE,
                "com/jjcperf/msg/msg/appt/ApptPutMessage.java", message);

        log.debug("I Got an Appointment Put Response!" + responseMessage);

        return responseMessage;
    }

    public Message sendUserDeleteMessage(long id) {
        UserGetMessage message = UserGetMessage
                .builder()
                .id(id)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a User Delete Request!")
                .build();

        log.debug("Sending a User Delete Request!");

        Message responseMessage = sendAndReceiveMessage(JmsConfig.USER_DELETE_QUEUE,
                "com/jjcperf/msg/msg/user/UserDeleteMessage.java", message);

        log.debug("I Got a User Delete Response!" + responseMessage);

        return responseMessage;
    }

    public Message sendAppointmentDeleteMessage(long id) {
        ApptGetMessage message = ApptGetMessage
                .builder()
                .id(id)
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending an Appt Delete Request!")
                .build();

        log.debug("Sending an Appt Delete Request!");

        Message responseMessage = sendAndReceiveMessage(JmsConfig.APPT_DELETE_QUEUE,
                "com/jjcperf/msg/msg/appt/ApptDeleteMessage.java", message);

        log.debug("I Got an Appointment Delete Response!" + responseMessage);

        return responseMessage;
    }

    //@Scheduled(fixedRate = 5000) //TODO remove this code once controller calls work correctly.
    public Message sendUserGetAllMessage() {
        UserGetAllMessage message = UserGetAllMessage
                .builder()
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending a User Get All Request!")
                .build();

        log.debug("Sending a User Get All Request!");

        Message responseMessage = sendAndReceiveMessage(JmsConfig.USER_GETALL_QUEUE,
                "com/jjcperf/msg/msg/user/UserGetAllMessage.java", message);

        log.debug("I Got a User Get All Response!" + responseMessage);

        return responseMessage;
    }

    @Scheduled(fixedRate = 5000) //TODO remove this code once controller calls work correctly.
    public Message sendAppointmentGetAllMessage() throws JMSException {
        ApptGetAllMessage message = ApptGetAllMessage
                .builder()
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message("Sending an Appt Get All Request!")
                .build();

        log.debug("Sending an Appt Get All Request!");

        Message responseMessage = sendAndReceiveMessage(JmsConfig.APPT_GETALL_QUEUE,
                "com.jjcperf.msg.msg.appt.ApptGetAllMessage", message);

        log.debug("I Got an Appointment GetAll Response!  " + responseMessage.getBody(String.class));

        return responseMessage;
    }

    private Message sendAndReceiveMessage(String queue, String type, Object messageToSend) {
        Message responseMessage = jmsTemplate.sendAndReceive(queue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = null;
                try {
                    message = session.createTextMessage(objectMapper.writeValueAsString(messageToSend));
                    message.setStringProperty("_type", type);
                }
                catch (JsonProcessingException jsonProcessingException) {
                    throw new JMSException(type + "creation failed");
                }

                return message;
            }
        });

        return responseMessage;
    }

}
