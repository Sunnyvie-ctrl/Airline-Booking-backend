package com.KORNN.airline_backend.dto;

import com.KORNN.airline_backend.model.Airport;

/**
 * DTO for Airport entity.
 * Used for airport CRUD operations.
 */
public class AirportDTO {

    private Long airportId;
    private String airportCode;
    private String airportName;
    private String city;
    private String country;

    // Constructors
    public AirportDTO() {
    }

    public AirportDTO(Long airportId, String airportCode, String airportName, String city, String country) {
        this.airportId = airportId;
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
    }

    /**
     * Converts Airport entity to AirportDTO.
     *
     * @param airport the airport entity
     * @return AirportDTO representation
     */
    public static AirportDTO fromEntity(Airport airport) {
        AirportDTO dto = new AirportDTO();
        dto.setAirportId(airport.getAirportId());
        dto.setAirportCode(airport.getAirportCode());
        dto.setAirportName(airport.getAirportName());
        dto.setCity(airport.getCity());
        dto.setCountry(airport.getCountry());
        return dto;
    }

    /**
     * Converts AirportDTO to Airport entity.
     *
     * @return Airport entity
     */
    public Airport toEntity() {
        Airport airport = new Airport();
        airport.setAirportId(this.airportId);
        airport.setAirportCode(this.airportCode);
        airport.setAirportName(this.airportName);
        airport.setCity(this.city);
        airport.setCountry(this.country);
        return airport;
    }

    // Getters and Setters
    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "AirportDTO{" +
                "airportId=" + airportId +
                ", airportCode='" + airportCode + '\'' +
                ", airportName='" + airportName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}