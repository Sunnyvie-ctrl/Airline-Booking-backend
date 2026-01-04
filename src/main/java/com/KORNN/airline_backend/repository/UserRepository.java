package com.KORNN.airline_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.KORNN.airline_backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository provides: save(), findById(), findAll(), deleteById(), etc.
}