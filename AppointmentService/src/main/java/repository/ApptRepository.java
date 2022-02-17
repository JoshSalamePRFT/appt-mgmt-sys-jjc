package repository;

import model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApptRepository extends JpaRepository<Appointment, Long> {

}
