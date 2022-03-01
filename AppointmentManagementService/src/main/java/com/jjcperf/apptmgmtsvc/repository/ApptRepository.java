package com.jjcperf.apptmgmtsvc.repository;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApptRepository extends JpaRepository<Appointment, Long> {

}
