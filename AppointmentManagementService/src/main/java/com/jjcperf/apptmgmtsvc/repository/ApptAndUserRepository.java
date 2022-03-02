/*package com.jjcperf.apptmgmtsvc.repository;

import com.jjcperf.apptmgmtsvc.model.Wrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApptAndUserRepository extends JpaRepository<Wrapper, Long> {
    List<Wrapper> findWrappersByAppointment_id(long appointment_id);
    List<Wrapper> findWrappersByUser_id(long user_id);
}*/
