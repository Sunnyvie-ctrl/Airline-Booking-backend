package com.KORNN.airline_backend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KORNN.airline_backend.dto.PlaneDTO;
import com.KORNN.airline_backend.model.Plane;
import com.KORNN.airline_backend.service.PlaneService;

/**
 * REST controller for Plane management.
 *
 * Responsibilities:
 * - CRUD operations for aircraft
 * - Accepts and returns DTOs
 */

@RestController
@RequestMapping("/api/planes")
public class PlaneController {

    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    /**
     * Creates a new plane.
     *
     * @param planeDTO plane data
     * @return created plane
     */
    @PostMapping
    public ResponseEntity<PlaneDTO> createPlane(@RequestBody PlaneDTO dto) {
        Plane plane = planeService.createPlane(dto.toEntity());
        return ResponseEntity.ok(PlaneDTO.fromEntity(plane));
    }

    /**
     * Retrieves all planes.
     *
     * @return list of planes
     */
    @GetMapping
    public ResponseEntity<List<PlaneDTO>> getAllPlanes() {
        List<PlaneDTO> planes = planeService.getAllPlanes()
                .stream()
                .map(PlaneDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(planes);
    }

    /**
     * Retrieves plane by ID.
     *
     * @return plane
     */
    @GetMapping("/{id}")
    public ResponseEntity<PlaneDTO> getPlaneById(@PathVariable Long id) {
        Plane plane = planeService.getPlaneById(id);
        return ResponseEntity.ok(PlaneDTO.fromEntity(plane));
    }

    /**
     * Updates an existing plane.
     *
     * @param id plane ID
     * @param planeDTO updated plane data
     * @return updated plane
     */
    @PutMapping("/{id}")
    public ResponseEntity<PlaneDTO> updatePlane(@PathVariable Long id,
                                                @RequestBody PlaneDTO dto) {
        Plane updated = planeService.updatePlane(id, dto.toEntity());
        return ResponseEntity.ok(PlaneDTO.fromEntity(updated));
    }

    /**
     * Deletes a plane by ID.
     *
     * @param id plane ID
     * @return empty response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        planeService.deletePlane(id);
        return ResponseEntity.noContent().build();
    }
}
