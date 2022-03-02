package com.jjcperf.apptmgmtsvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashSet;
import java.util.Set;


//TODO Inherit from a parent class to get audit properties

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class    UserDTO extends BaseDTO {

    private long user_id = -1;

    @NotBlank
    @JsonProperty()
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

    @NotBlank
    private String phoneNumber;

    private Set<Appointment> appointments = new HashSet<>();

    public void SetValues(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        UserDTO dummy = mapper.readValue(json, UserDTO.class);
        firstName = dummy.firstName;
        lastName = dummy.lastName;
        gender = dummy.gender;
        age = dummy.age;
        emailAddress= dummy.emailAddress;
        phoneNumber = dummy.phoneNumber;
    }
}
