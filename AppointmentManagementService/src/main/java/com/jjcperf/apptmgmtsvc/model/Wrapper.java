/*package com.jjcperf.apptmgmtsvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_appointments")
public class Wrapper {
    //TODO add apptAndUserId??
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appt_and_user_id;

    @Column
    private long user_id;

    @Column
    private long appointment_id;
}
*/