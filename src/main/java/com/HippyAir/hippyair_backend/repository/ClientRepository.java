package com.HippyAir.hippyair_backend.repository;

import com.HippyAir.hippyair_backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    // Primary key is passport number (String)
}
