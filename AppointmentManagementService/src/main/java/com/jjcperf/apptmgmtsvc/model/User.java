package com.jjcperf.apptmgmtsvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User extends BaseEntity implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Null
    private long user_id;

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @Column(name = "gender")
    @NotBlank
    private String gender;
    //consider making enum

    @Column(name = "age")
    @PositiveOrZero
    private int age;

    @Column(name = "email_address")
    @NotBlank
    @Email
    private String emailAddress;

    @Column(name = "phone_number")
    @NotBlank
    private String phoneNumber;

    @ManyToMany()
    @JoinTable(
            name = "users_appointments",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id")
    )
    @JsonIgnore /* this annotation is required on either this set of appointments or the set of users in the appt entity.
                   if you don't you will cause an infinite loop when retrieving info. */
    //This provides the mapping. In the other table, use this variable for the mappedBy value. mappedBy="appointments"
    private Set<Appointment> appointments = new HashSet<>();
}
