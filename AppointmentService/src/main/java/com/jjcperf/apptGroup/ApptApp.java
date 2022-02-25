package com.jjcperf.apptGroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.jjcperf.msg", "com.jjcperf.apptGroup" } )
public class ApptApp {
    public static void main(String[] args) {
        SpringApplication.run(ApptApp.class, args);
    }
}
