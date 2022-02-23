package com.apptGroup.repository;

import com.apptGroup.ApptApp;
import com.apptGroup.model.Appointment;
import com.apptGroup.repository.ApptRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes=ApptApp.class)
class ApptRepositoryTests {

    @Autowired
    private ApptRepository apptRepo;
    private Appointment appt;

    @BeforeEach
    public void setup() {
        appt = Appointment.builder()
                .appt_id(1L)
                .apptName("testAppt")
                .apptType("testType")
                .description("Test Description")
                .build();

        apptRepo.save(this.appt);
        this.id = this.appt.getAppointment_id();
    }

    @AfterEach
    public void teardown() {
        apptRepo.deleteAll();
        appt = null;
    }

    @Test
    public void saveApptTest() {
        Appointment appt1 = apptRepo.save(appt);
        assertEquals(1L, appt1.getAppointment_id());
    }

    @Test
    public void getApptTest() {
        apptRepo.save(appt);
        Appointment appt1 = apptRepo.getById(1L);
        assertEquals(appt.getApptName(), appt1.getApptName());
    }

    @Test
    public void updateApptTest() {
        Appointment appt1 = apptRepo.save(appt);
        appt = Appointment.builder()
                .appointment_id(1L)
                .apptName("UpdatedTestName")
                .apptType("UpdatedTestType")
                .description("This test has been updated")
                .build();

        Appointment appt2 = apptRepo.save(appt);

        assertEquals(appt1.getAppointment_id(), appt2.getAppointment_id());
        assertNotEquals(appt1.getApptName(), appt2.getApptName());
    }

    @Test
    public void deleteApptTest() {
        apptRepo.save(appt);
        assertTrue(apptRepo.findById(1L).isPresent());
        apptRepo.deleteById(1L);
        assertFalse(apptRepo.findById(1L).isPresent());
    }

}
