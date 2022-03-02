package com.jjcperf.apptmgmtsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jjcperf.msg", "com.jjcperf.apptmgmtsvc"})
public class AppointmentManagementServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppointmentManagementServiceApplication.class, args);
    }

}
