package app;

import com.apptGroup.ApptApp;
import com.apptGroup.model.Appointment;
import com.apptGroup.repository.ApptRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=ApptApp.class)
class ApptRepositoryTests {

    @Autowired
    private ApptRepository apptRepo;
    private long testIdHolder;
    //private ApptController apptcon;

    @Test
    public void saveApptTest() {
        Appointment appt = Appointment.builder()
                .apptName("testAppt")
                .apptType("testType")
                .description("Test Description")
                .build();

        apptRepo.save(appt);

        this.testIdHolder = appt.getAppt_id();
        Assertions.assertThat(appt.getAppt_id()).isGreaterThan(0);

    }

    @Test
    public void getApptTest() {
        Appointment appt = apptRepo.getById(this.testIdHolder);

        Assertions.assertThat(appt.getAppt_id()).isEqualTo(this.testIdHolder);
    }

}
