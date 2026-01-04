package com.KORNN.airline_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_airport")
    private Long idAirport;

    @Column(name = "name_airport", nullable = false)
    private String nameAirport;

    @Column(name = "country_airport")
    private String countryAirport;

    @Column(name = "city_airport")
    private String cityAirport;

    // Default constructor (required by JPA)
    public Airport() {
    }

    // Constructor with fields
    public Airport(String nameAirport, String countryAirport, String cityAirport) {
        this.nameAirport = nameAirport;
        this.countryAirport = countryAirport;
        this.cityAirport = cityAirport;
    }

    // Getters and Setters
    public Long getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(Long idAirport) {
        this.idAirport = idAirport;
    }

    public String getNameAirport() {
        return nameAirport;
    }

    public void setNameAirport(String nameAirport) {
        this.nameAirport = nameAirport;
    }

    public String getCountryAirport() {
        return countryAirport;
    }

    public void setCountryAirport(String countryAirport) {
        this.countryAirport = countryAirport;
    }

    public String getCityAirport() {
        return cityAirport;
    }

    public void setCityAirport(String cityAirport) {
        this.cityAirport = cityAirport;
    }
}