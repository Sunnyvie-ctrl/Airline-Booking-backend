package com.KORNN.airline_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plane")
    private Long idPlane;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "manufacturing_year")
    private Integer manufacturingYear;
    public Plane() {
    }

    public Plane(String brand, String model, Integer manufacturingYear) {
        this.brand = brand;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
    }

    public Long getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(Long idPlane) {
        this.idPlane = idPlane;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(Integer manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }
}