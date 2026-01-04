package fr.epita.timeoutairline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fr.epita.timeoutairline.model.Plane;
import fr.epita.timeoutairline.service.PlaneService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    // CREATE - POST /api/v1/planes
    @PostMapping
    public Plane createPlane(@RequestBody Plane plane) {
        return planeService.createPlane(plane);
    }

    // READ ALL - GET /api/v1/planes
    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    // READ ONE - GET /api/v1/planes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable Long id) {
        return planeService.getPlaneById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - PUT /api/v1/planes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Plane> updatePlane(@PathVariable Long id, @RequestBody Plane planeDetails) {
        try {
            Plane updatedPlane = planeService.updatePlane(id, planeDetails);
            return ResponseEntity.ok(updatedPlane);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - DELETE /api/v1/planes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        try {
            planeService.deletePlane(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}