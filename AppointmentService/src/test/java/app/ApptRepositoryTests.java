package app;

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

@SpringBootTest(classes=ApptApp.class)
class ApptRepositoryTests {

    @Autowired
    private ApptRepository apptRepo;
    private long id;
    private Appointment appt;
    //private ApptController apptcon;

    @BeforeEach
    public void setup() {
        this.appt = Appointment.builder()
                .apptName("testAppt")
                .apptType("testType")
                .description("Test Description")
                .build();

        apptRepo.save(this.appt);
        this.id = this.appt.getAppointment_id();
    }

    @AfterEach
    public void takedown() {
        apptRepo.deleteAll();
    }

    @Test
    public void saveApptTest() {
        Assertions.assertThat(this.appt.getAppointment_id()).isEqualTo(this.id);
    }

    @Test
    public void getApptTest() {
        this.appt = apptRepo.getById(this.id);

        Assertions.assertThat(this.appt.getAppointment_id()).isEqualTo(this.id);
    }

    @Test
    public void updateApptTest() {
        this.appt = Appointment.builder()
                .appointment_id(this.id)
                .apptName("UpdatedTestName")
                .apptType("UpdatedTestType")
                .description("This test has been updated")
                .build();

        apptRepo.save(this.appt);

        Assertions.assertThat(this.appt.getAppointment_id()).isEqualTo(this.id);
    }

    @Test
    public void deleteApptTest() {
        apptRepo.deleteById(this.id);

        Assertions.assertThat(apptRepo.findById(this.id).isPresent()).isFalse();
    }

}
