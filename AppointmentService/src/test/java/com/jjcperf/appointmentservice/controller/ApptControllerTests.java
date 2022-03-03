package com.jjcperf.appointmentservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.appointmentservice.model.Appointment;
import com.jjcperf.appointmentservice.service.ApptService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ApptControllerTests {
    //TODO add more tests

    @Mock
    private ApptService apptService;

    private Appointment appt;
    private List<Appointment> apptList;

    @InjectMocks
    private ApptController apptController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        System.out.println("Performing setup.");
        appt = Appointment.builder()
                .appointment_id(1)
                .apptName("Doctor")
                .apptType("Annual")
                .description("A test appointment")
                .startTime(LocalDateTime.parse("2022-03-15T13:30:00"))
                .endTime(LocalDateTime.parse("2022-03-15T14:00:00"))
                .metaData("Filler Data")
                .build();

        mockMvc = MockMvcBuilders.standaloneSetup(apptController).build();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Performing teardown.");
        appt = null;
    }

    //TODO fix post test
    @Test
    public void postTest() throws Exception {
        System.out.println("PostTest started.");
        when(apptService.createAppt(any())).thenReturn(appt);
        mockMvc.perform(post("/api/v1/appt/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(appt)))
                .andExpect(status().isCreated());
        verify(apptService,times(1)).createAppt(any());
    }

    @Test
    public void getAllTest() throws Exception {
        System.out.println("GetAllTest started.");
        when(apptService.findAllAppts()).thenReturn(apptList);
        mockMvc.perform(get("/api/v1/appt/findAll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(appt)))
                .andDo(MockMvcResultHandlers.print());

        //Verify that the service called listUsers
        verify(apptService).findAllAppts();
        verify(apptService,times(1)).findAllAppts();
    }

    @Test
    public void getTest() throws Exception {
        System.out.println("GetTest started.");
        when(apptService.readAppt(appt.getAppointment_id())).thenReturn(appt);
        mockMvc.perform(get("/api/v1/appt/read/" + appt.getAppointment_id())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(appt)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    //TODO check: not sure this should be passing.
    @Test
    public void deleteTest() throws Exception {
        System.out.println("DeleteTest started.");
        mockMvc.perform(delete("/api/v1/appt/delete/" + appt.getAppointment_id()))
                .andExpect(status().isNoContent())
                .andDo(MockMvcResultHandlers.print());
    }

    //Might need to create a custom mapper because of the phoneNumber property
    public static String asJsonString(final Object obj) {
        System.out.println("AsJSONString started.");
        try {
            ObjectMapper om = new ObjectMapper();
            om.findAndRegisterModules();
            System.out.println("Just before the WriteValue call");
            return om.writeValueAsString(obj);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
