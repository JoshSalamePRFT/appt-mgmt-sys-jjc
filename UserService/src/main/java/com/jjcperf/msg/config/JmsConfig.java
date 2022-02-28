package com.jjcperf.msg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {
    public static final String USER_GET_QUEUE = "user-get";
    public static final String USER_POST_QUEUE = "user-post";
    public static final String USER_PUT_QUEUE = "user-put";
    public static final String USER_DELETE_QUEUE = "user-delete";
    public static final String USER_GETALL_QUEUE = "user-getall";

    @Bean
    public MessageConverter messageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
