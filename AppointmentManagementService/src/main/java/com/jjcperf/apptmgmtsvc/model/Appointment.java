package com.jjcperf.apptmgmtsvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private long appt_id;

    @Column(name="appt_name", nullable = false)
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
