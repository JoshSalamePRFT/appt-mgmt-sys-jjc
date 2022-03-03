package com.jjcperf.apptmgmtsvc.repository;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query(value = """
            select users.*
            from users, appointments, users_appointments
            where users.user_id = users_appointments.user_id
                and appointments.appointment_id = users_appointments.appointment_id
                and appointments.appointment_id = ?1""",
            nativeQuery = true)
    List<Long> getUsersByAppointmentId(long id);
}
