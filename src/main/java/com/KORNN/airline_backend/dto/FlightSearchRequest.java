package fr.epita.timeoutairline.dto;

import java.time.LocalDate;

public class FlightSearchRequest {

    private String departureCity;
    private String arrivalCity;
    private LocalDate departureDate;

    // Default constructor
    public FlightSearchRequest() {
    }

    // Constructor with fields
    public FlightSearchRequest(String departureCity, String arrivalCity, LocalDate departureDate) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDate = departureDate;
    }

    // Getters and Setters
    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}