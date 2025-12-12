package com.HippyAir.hippyair_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HippyAir.hippyair_backend.Model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
