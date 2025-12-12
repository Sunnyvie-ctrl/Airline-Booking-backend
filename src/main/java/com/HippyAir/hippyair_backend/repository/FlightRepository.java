package com.HippyAir.hippyair_backend.repository;

import com.HippyAir.hippyair_backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    // Custom query to search flights
    List<Flight> findByDepartureCityAndArrivalCityAndDepartureHour(String departureCity, String arrivalCity, String departureHour);
}
