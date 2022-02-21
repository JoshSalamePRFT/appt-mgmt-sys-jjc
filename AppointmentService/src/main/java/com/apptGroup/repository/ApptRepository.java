package com.apptGroup.repository;

import com.apptGroup.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Repository
public interface ApptRepository extends JpaRepository<Appointment, Long> {

}
