package com.jjcperf.userservice.repository;

import com.jjcperf.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
