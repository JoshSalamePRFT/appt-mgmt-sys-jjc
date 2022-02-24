<<<<<<< Updated upstream:AppointmentService/src/main/java/com/apptGroup/msg/config/JmsConfig.java
package com.apptGroup.msg.config;
=======
package com.jjcperf.msg.config;
>>>>>>> Stashed changes:AppointmentManagementService/src/main/java/com/jjcperf/msg/config/JmsConfig.java

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

    public static final String MY_QUEUE = "my-hello-world";
    public static final String MY_SEND_RCV_QUEUE = "replybacktome";

    @Bean
    public MessageConverter messageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
<<<<<<< Updated upstream:AppointmentService/src/main/java/com/apptGroup/msg/config/JmsConfig.java
}
=======
}
>>>>>>> Stashed changes:AppointmentManagementService/src/main/java/com/jjcperf/msg/config/JmsConfig.java
