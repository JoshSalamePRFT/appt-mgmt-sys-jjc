package com.jjcperf.msg.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

    public static final String APPT_GET_QUEUE = "appt-get";
    public static final String APPT_POST_QUEUE = "appt-post";
    public static final String APPT_PUT_QUEUE = "appt-put";
    public static final String APPT_DELETE_QUEUE = "appt-delete";
    public static final String APPT_GETALL_QUEUE = "appt-getall";

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}
