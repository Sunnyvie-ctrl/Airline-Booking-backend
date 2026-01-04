package fr.epita.timeoutairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.epita.timeoutairline.model.Airport;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    
    // Custom method: find airports by city
    List<Airport> findByCityAirport(String cityAirport);
}