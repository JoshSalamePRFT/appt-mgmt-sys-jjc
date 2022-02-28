package com.jjcperf.appointmentservice.repository;

import com.jjcperf.appointmentservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApptRepository extends JpaRepository<Appointment, Long> {

}
