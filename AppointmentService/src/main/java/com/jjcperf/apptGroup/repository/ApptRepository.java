package com.jjcperf.apptGroup.repository;

import com.jjcperf.apptGroup.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ApptRepository extends JpaRepository<Appointment, Long> {

}
