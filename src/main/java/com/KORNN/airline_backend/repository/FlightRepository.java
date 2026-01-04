package fr.epita.timeoutairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.epita.timeoutairline.model.Flight;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    
    // Custom method: search flights (for feature #6)
    List<Flight> findByDepartureCityAndArrivalCityAndDepartureDate(
        String departureCity, 
        String arrivalCity, 
        LocalDate departureDate
    );
}