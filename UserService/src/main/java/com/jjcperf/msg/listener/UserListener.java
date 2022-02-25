package com.jjcperf.msg.listener;

import com.jjcperf.msg.config.JmsConfig;
import com.jjcperf.msg.msg.GetMessage;
import com.jjcperf.msg.sender.UserSender;
import com.jjcperf.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@RequiredArgsConstructor
@Component
public class UserListener {

    @Autowired
    private UserSender userSender;

    @JmsListener(destination = JmsConfig.USER_REQ_QUEUE)
    public void listenForUserReq(@Payload GetMessage getMessage,
                                 @Headers MessageHeaders headers,
                                 Message message) {

        System.out.println("I Got a User Request!!!!! ID: " + getMessage.getMessage());
        System.out.println(getMessage);

        userSender.sendUserResponseMessage(Long.parseLong(getMessage.getMessage()));
    }

}
