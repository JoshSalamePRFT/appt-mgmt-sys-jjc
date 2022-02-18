package com.apptGroup.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue
    private long appt_id;

    @Column(name="appt_name")
    private String apptName;

    @Column(name="appt_type")
    private String apptType;

    private String description;

    @Column(name="start_time")
    private Time startTime;

    @Column(name="end_time")
    private Time endTime;

    @Column(name="meta_data")
    private String metaData;

}