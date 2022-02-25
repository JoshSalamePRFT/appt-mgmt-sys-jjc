package com.jjcperf.apptGroup.repository;

import com.jjcperf.apptGroup.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApptRepository extends JpaRepository<Appointment, Long> {

}
