package fr.epita.timeoutairline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fr.epita.timeoutairline.model.Airport;
import fr.epita.timeoutairline.service.AirportService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    // CREATE - POST /api/v1/airports
    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.createAirport(airport);
    }

    // READ ALL - GET /api/v1/airports
    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    // READ ONE - GET /api/v1/airports/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        return airportService.getAirportById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // READ BY CITY - GET /api/v1/airports/city/{city}
    @GetMapping("/city/{city}")
    public List<Airport> getAirportsByCity(@PathVariable String city) {
        return airportService.getAirportsByCity(city);
    }

    // UPDATE - PUT /api/v1/airports/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport airportDetails) {
        try {
            Airport updatedAirport = airportService.updateAirport(id, airportDetails);
            return ResponseEntity.ok(updatedAirport);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - DELETE /api/v1/airports/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        try {
            airportService.deleteAirport(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}