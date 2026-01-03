package com.KORNN.airline_backend.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KORNN.airline_backend.dto.FlightDTO;
import com.KORNN.airline_backend.model.Flight;
import com.KORNN.airline_backend.service.FlightService;

/**
 * REST controller for Flight management.
 *
 * Responsibilities:
 * - CRUD and search flights
 * - Uses DTOs for input/output
 */
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<FlightDTO> createFlight(@RequestBody FlightDTO dto) {
        Flight flight = flightService.createFlight(dto.toEntity());
        return ResponseEntity.ok(FlightDTO.fromEntity(flight));
    }

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        List<FlightDTO> flights = flightService.getAllFlights()
                .stream()
                .map(FlightDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{flightNumber}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable String flightNumber) {
        Flight flight = flightService.getFlightByNumber(flightNumber);
        return ResponseEntity.ok(FlightDTO.fromEntity(flight));
    }

    @PutMapping("/{flightNumber}")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable String flightNumber,
                                                  @RequestBody FlightDTO dto) {
        Flight updated = flightService.updateFlight(flightNumber, dto.toEntity());
        return ResponseEntity.ok(FlightDTO.fromEntity(updated));
    }

    @DeleteMapping("/{flightNumber}")
    public ResponseEntity<Void> deleteFlight(@PathVariable String flightNumber) {
        flightService.deleteFlight(flightNumber);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightDTO>> searchFlights(
            @RequestParam String departureCity,
            @RequestParam String arrivalCity,
            @RequestParam LocalDate departureDate) {

        List<FlightDTO> results = flightService
                .searchFlights(departureCity, arrivalCity, departureDate)
                .stream()
                .map(FlightDTO::fromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(results);
    }
}

