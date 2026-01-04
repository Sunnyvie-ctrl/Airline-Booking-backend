package fr.epita.timeoutairline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.epita.timeoutairline.model.Airport;
import fr.epita.timeoutairline.repository.AirportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    // Create
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    // Read all
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    // Read one by ID
    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    // Read by city
    public List<Airport> getAirportsByCity(String city) {
        return airportRepository.findByCityAirport(city);
    }

    // Update
    public Airport updateAirport(Long id, Airport airportDetails) {
        Airport airport = airportRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Airport not found with id: " + id));
        
        airport.setNameAirport(airportDetails.getNameAirport());
        airport.setCountryAirport(airportDetails.getCountryAirport());
        airport.setCityAirport(airportDetails.getCityAirport());
        
        return airportRepository.save(airport);
    }

    // Delete
    public void deleteAirport(Long id) {
        Airport airport = airportRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Airport not found with id: " + id));
        airportRepository.delete(airport);
    }
}