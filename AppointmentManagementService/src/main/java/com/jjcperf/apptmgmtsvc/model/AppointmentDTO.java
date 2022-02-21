package com.jjcperf.apptmgmtsvc.model;

import lombok.Data;

import java.sql.Time;

@Data
public class AppointmentDTO {

    private long appt_id;

    private String apptName;

    private String apptType;

    private String description;

    private Time startTime;

    private Time endTime;

    private String metaData;

}
