package com.KORNN.airline_backend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KORNN.airline_backend.dto.AirportDTO;
import com.KORNN.airline_backend.model.Airport;
import com.KORNN.airline_backend.service.AirportService;

/**
 * REST controller for Airport management.
 *
 * Responsibilities:
 * - CRUD operations
 * - Uses DTOs for input/output
 */
@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    public ResponseEntity<AirportDTO> createAirport(@RequestBody AirportDTO dto) {
        Airport airport = airportService.createAirport(dto.toEntity());
        return ResponseEntity.ok(AirportDTO.fromEntity(airport));
    }

    @GetMapping
    public ResponseEntity<List<AirportDTO>> getAllAirports() {
        List<AirportDTO> airports = airportService.getAllAirports()
                .stream()
                .map(AirportDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(airports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDTO> getAirportById(@PathVariable Long id) {
        Airport airport = airportService.getAirportById(id);
        return ResponseEntity.ok(AirportDTO.fromEntity(airport));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportDTO> updateAirport(@PathVariable Long id,
                                                    @RequestBody AirportDTO dto) {
        Airport updated = airportService.updateAirport(id, dto.toEntity());
        return ResponseEntity.ok(AirportDTO.fromEntity(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }
}
