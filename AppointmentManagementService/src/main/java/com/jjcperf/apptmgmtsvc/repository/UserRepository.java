package com.jjcperf.apptmgmtsvc.repository;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select appointments.*\n" +
            "from users, appointments, users_appointments\n" +
            "where users.user_id = users_appointments.user_id\n" +
            "    and appointments.appointment_id = users_appointments.appointment_id\n" +
            "    and users.user_id = ?1", nativeQuery = true)
    List<Long> getAppointmentsByUserId(long id);
}
