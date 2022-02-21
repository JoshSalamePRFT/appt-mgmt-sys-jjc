package com.example.userservice.model;

import com.example.userservice.phoneHandling.Phone;
import com.example.userservice.phoneHandling.PhoneNumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.PositiveOrZero;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
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

    @Columns(columns = {
            @Column(name = "phone_number_value"),
            @Column(name = "phone_number_locale") })
    @Phone
    @Type(type = "com.example.userservice.phoneHandling.PhoneNumberType")
    private PhoneNumber phoneNumber;
}
