package com.jjcperf.msg.sender;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.msg.config.JmsConfig;
import com.jjcperf.msg.enums.CriteriaTypeEnum;
import com.jjcperf.msg.msg.GetMessage;
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


    @Scheduled(fixedRate = 2000)
//    public void sendUserGetMessage (long id) {
    public void sendUserGetMessage() {
        long id = 1;
        GetMessage message = GetMessage
                .builder()
                .id(UUID.randomUUID())
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message(String.valueOf(id))
                .build();

        System.out.println("Sending a User Request!!");
        jmsTemplate.convertAndSend(JmsConfig.USER_REQ_QUEUE, message);
    }

    public void sendApptGetMessage(long id) {
        GetMessage message = GetMessage
                .builder()
                .id(UUID.randomUUID())
                .criteriaType(CriteriaTypeEnum.NUMBER)
                .message(String.valueOf(id))
                .build();

        System.out.println("Sending an Appt Request!!");
        jmsTemplate.convertAndSend(JmsConfig.APPT_REQ_QUEUE, message);
    }
}
