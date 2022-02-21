package com.example.userservice.model;

import com.example.userservice.phoneHandling.Phone;
import com.example.userservice.phoneHandling.PhoneNumber;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Null
    @JsonProperty("user_id")
    private long user_id;

    @Column(name = "first_name")
    @NotBlank
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "gender")
    @NotBlank
    @JsonProperty("gender")
    private String gender;
    //consider making enum

    @Column(name = "age")
    @PositiveOrZero
    @JsonProperty("age")
    private int age;

    @Column(name = "email_address")
    @NotBlank
    @Email
    @JsonProperty("emailAddress")
    private String emailAddress;

    @Columns(columns = {
            @Column(name = "phone_number_value"),
            @Column(name = "phone_number_locale") })
    @Phone
    @Type(type = "com.example.userservice.phoneHandling.PhoneNumberType")
    @JsonProperty("phoneNumber")
    private PhoneNumber phoneNumber;
}
