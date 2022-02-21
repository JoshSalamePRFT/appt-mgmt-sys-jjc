package app;

import com.apptGroup.ApptApp;
import com.apptGroup.model.Appointment;
import com.apptGroup.repository.ApptRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=ApptApp.class)
class ApptRepositoryTests {

    @Autowired
    private ApptRepository apptRepo;
    //private ApptController apptcon;

    @Test
    public void saveApptTest() {
        Appointment appt = Appointment.builder()
                .apptName("testAppt")
                .apptType("testType")
                .description("Test Description")
                .build();

        apptRepo.save(appt);

        Assertions.assertThat(appt.getAppt_id()).isGreaterThan(0);
    }

}
