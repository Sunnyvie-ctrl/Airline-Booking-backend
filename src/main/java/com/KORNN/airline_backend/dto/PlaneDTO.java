package com.KORNN.airline_backend.dto;

import com.KORNN.airline_backend.model.Plane;

/**
 * DTO for Plane entity.
 * Used for plane CRUD operations.
 */
public class PlaneDTO {

    private Long planeId;
    private String registrationNumber;
    private String model;
    private String manufacturer;
    private Integer capacity;
    private Integer yearManufactured;
    private String status;

    // Constructors
    public PlaneDTO() {
    }

    public PlaneDTO(Long planeId, String registrationNumber, String model, String manufacturer,
                    Integer capacity, Integer yearManufactured, String status) {
        this.planeId = planeId;
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.yearManufactured = yearManufactured;
        this.status = status;
    }

    /**
     * Converts Plane entity to PlaneDTO.
     *
     * @param plane the plane entity
     * @return PlaneDTO representation
     */
    public static PlaneDTO fromEntity(Plane plane) {
        PlaneDTO dto = new PlaneDTO();
        dto.setPlaneId(plane.getPlaneId());
        dto.setRegistrationNumber(plane.getRegistrationNumber());
        dto.setModel(plane.getModel());
        dto.setManufacturer(plane.getManufacturer());
        dto.setCapacity(plane.getCapacity());
        dto.setYearManufactured(plane.getYearManufactured());
        dto.setStatus(plane.getStatus());
        return dto;
    }

    /**
     * Converts PlaneDTO to Plane entity.
     *
     * @return Plane entity
     */
    public Plane toEntity() {
        Plane plane = new Plane();
        plane.setPlaneId(this.planeId);
        plane.setRegistrationNumber(this.registrationNumber);
        plane.setModel(this.model);
        plane.setManufacturer(this.manufacturer);
        plane.setCapacity(this.capacity);
        plane.setYearManufactured(this.yearManufactured);
        plane.setStatus(this.status);
        return plane;
    }

    // Getters and Setters
    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(Integer yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PlaneDTO{" +
                "planeId=" + planeId +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", capacity=" + capacity +
                ", yearManufactured=" + yearManufactured +
                ", status='" + status + '\'' +
                '}';
    }
}