package com.jjcperf.apptmgmtsvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long user_id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String gender;
    //consider making enum

    @PositiveOrZero
    private int age;

    @NotBlank
    @Email
    private String emailAddress;

    @Column(name = "phone_number")
    @NotBlank
    private String phoneNumber;

    private Set<Appointment> appointments = new HashSet<>();

}
