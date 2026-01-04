package fr.epita.timeoutairline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.epita.timeoutairline.model.Flight;
import fr.epita.timeoutairline.model.Plane;
import fr.epita.timeoutairline.model.Airport;
import fr.epita.timeoutairline.repository.FlightRepository;
import fr.epita.timeoutairline.repository.PlaneRepository;
import fr.epita.timeoutairline.repository.AirportRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private AirportRepository airportRepository;

    // Create
    public Flight createFlight(Flight flight) {
        // Fetch the actual Plane from database
        if (flight.getPlane() != null && flight.getPlane().getIdPlane() != null) {
            Plane plane = planeRepository.findById(flight.getPlane().getIdPlane())
                .orElseThrow(() -> new RuntimeException("Plane not found with id: " + flight.getPlane().getIdPlane()));
            flight.setPlane(plane);
        }

        // Fetch the actual Departure Airport from database
        if (flight.getDepartureAirport() != null && flight.getDepartureAirport().getIdAirport() != null) {
            Airport departureAirport = airportRepository.findById(flight.getDepartureAirport().getIdAirport())
                .orElseThrow(() -> new RuntimeException("Departure Airport not found with id: " + flight.getDepartureAirport().getIdAirport()));
            flight.setDepartureAirport(departureAirport);
        }

        // Fetch the actual Arrival Airport from database
        if (flight.getArrivalAirport() != null && flight.getArrivalAirport().getIdAirport() != null) {
            Airport arrivalAirport = airportRepository.findById(flight.getArrivalAirport().getIdAirport())
                .orElseThrow(() -> new RuntimeException("Arrival Airport not found with id: " + flight.getArrivalAirport().getIdAirport()));
            flight.setArrivalAirport(arrivalAirport);
        }

        return flightRepository.save(flight);
    }

    // Read all
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Read one by flight number
    public Optional<Flight> getFlightByNumber(String flightNumber) {
        return flightRepository.findById(flightNumber);
    }

    // Search flights (Feature #6)
    public List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDate departureDate) {
        return flightRepository.findByDepartureCityAndArrivalCityAndDepartureDate(
            departureCity, arrivalCity, departureDate
        );
    }

    // Update
    public Flight updateFlight(String flightNumber, Flight flightDetails) {
        Flight flight = flightRepository.findById(flightNumber)
            .orElseThrow(() -> new RuntimeException("Flight not found with number: " + flightNumber));

        flight.setDepartureCity(flightDetails.getDepartureCity());
        flight.setArrivalCity(flightDetails.getArrivalCity());
        flight.setDepartureHour(flightDetails.getDepartureHour());
        flight.setArrivalHour(flightDetails.getArrivalHour());
        flight.setDepartureDate(flightDetails.getDepartureDate());
        flight.setNumberOfSeat(flightDetails.getNumberOfSeat());
        flight.setFirstClassSeatPrice(flightDetails.getFirstClassSeatPrice());
        flight.setPremiumSeatPrice(flightDetails.getPremiumSeatPrice());
        flight.setBusinessClassPrice(flightDetails.getBusinessClassPrice());
        flight.setEconomicsClassPrice(flightDetails.getEconomicsClassPrice());

        // Fetch related entities
        if (flightDetails.getPlane() != null && flightDetails.getPlane().getIdPlane() != null) {
            Plane plane = planeRepository.findById(flightDetails.getPlane().getIdPlane())
                .orElseThrow(() -> new RuntimeException("Plane not found"));
            flight.setPlane(plane);
        }

        if (flightDetails.getDepartureAirport() != null && flightDetails.getDepartureAirport().getIdAirport() != null) {
            Airport departureAirport = airportRepository.findById(flightDetails.getDepartureAirport().getIdAirport())
                .orElseThrow(() -> new RuntimeException("Departure Airport not found"));
            flight.setDepartureAirport(departureAirport);
        }

        if (flightDetails.getArrivalAirport() != null && flightDetails.getArrivalAirport().getIdAirport() != null) {
            Airport arrivalAirport = airportRepository.findById(flightDetails.getArrivalAirport().getIdAirport())
                .orElseThrow(() -> new RuntimeException("Arrival Airport not found"));
            flight.setArrivalAirport(arrivalAirport);
        }

        return flightRepository.save(flight);
    }

    // Delete
    public void deleteFlight(String flightNumber) {
        Flight flight = flightRepository.findById(flightNumber)
            .orElseThrow(() -> new RuntimeException("Flight not found with number: " + flightNumber));
        flightRepository.delete(flight);
    }
}
