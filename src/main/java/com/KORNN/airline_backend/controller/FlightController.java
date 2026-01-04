package fr.epita.timeoutairline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fr.epita.timeoutairline.model.Flight;
import fr.epita.timeoutairline.service.FlightService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // CREATE - POST /api/v1/flights
    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }

    // READ ALL - GET /api/v1/flights
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // READ ONE - GET /api/v1/flights/{flightNumber}
    @GetMapping("/{flightNumber}")
    public ResponseEntity<Flight> getFlightByNumber(@PathVariable String flightNumber) {
        return flightService.getFlightByNumber(flightNumber)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // SEARCH FLIGHTS - GET /api/v1/flights/search?from=Paris&to=London&date=2025-01-15
    // This is Feature #6 from project requirements
    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return flightService.searchFlights(from, to, date);
    }

    // UPDATE - PUT /api/v1/flights/{flightNumber}
    @PutMapping("/{flightNumber}")
    public ResponseEntity<Flight> updateFlight(@PathVariable String flightNumber, @RequestBody Flight flightDetails) {
        try {
            Flight updatedFlight = flightService.updateFlight(flightNumber, flightDetails);
            return ResponseEntity.ok(updatedFlight);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - DELETE /api/v1/flights/{flightNumber}
    @DeleteMapping("/{flightNumber}")
    public ResponseEntity<Void> deleteFlight(@PathVariable String flightNumber) {
        try {
            flightService.deleteFlight(flightNumber);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
