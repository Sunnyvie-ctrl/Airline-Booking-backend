package fr.epita.timeoutairline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto increment
    private Long idAirport;

    private String nameAirport;
    private String countryAirport;
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