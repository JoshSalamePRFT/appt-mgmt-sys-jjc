package com.apptGroup.repository;

import com.apptGroup.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApptRepository extends JpaRepository<Appointment, Long> {

}
