package com.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false, name = "appointment_id")
    private long appointment_id;

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

    @ManyToMany(mappedBy = "appointments")
    private Set<User> users = new HashSet<>();

}
