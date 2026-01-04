package fr.epita.timeoutairline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.epita.timeoutairline.model.Plane;
import fr.epita.timeoutairline.repository.PlaneRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    // Create
    public Plane createPlane(Plane plane) {
        return planeRepository.save(plane);
    }

    // Read all
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    // Read one by ID
    public Optional<Plane> getPlaneById(Long id) {
        return planeRepository.findById(id);
    }

    // Update
    public Plane updatePlane(Long id, Plane planeDetails) {
        Plane plane = planeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Plane not found with id: " + id));
        
        plane.setBrand(planeDetails.getBrand());
        plane.setModel(planeDetails.getModel());
        plane.setManufacturingYear(planeDetails.getManufacturingYear());
        
        return planeRepository.save(plane);
    }

    // Delete
    public void deletePlane(Long id) {
        Plane plane = planeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Plane not found with id: " + id));
        planeRepository.delete(plane);
    }
}