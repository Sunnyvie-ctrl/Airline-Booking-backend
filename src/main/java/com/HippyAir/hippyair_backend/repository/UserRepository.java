package com.HippyAir.hippyair_backend.repository;

import com.HippyAir.hippyair_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Add custom queries if needed
}
