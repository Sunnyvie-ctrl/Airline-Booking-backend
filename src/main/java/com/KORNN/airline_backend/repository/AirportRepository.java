package com.KORNN.airline_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.KORNN.airline_backend.model.Airport;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    
    // Custom method: find airports by city
    List<Airport> findByCityAirport(String cityAirport);
}