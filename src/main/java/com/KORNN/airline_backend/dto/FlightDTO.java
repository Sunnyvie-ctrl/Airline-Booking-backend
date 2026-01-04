package com.KORNN.airline_backend.dto;

import java.time.LocalDateTime;

import com.KORNN.airline_backend.model.Flight;

/**
 * DTO for Flight entity.
 * Used for flight CRUD and search operations.
 */
public class FlightDTO {

    private Long flightId;
    private String flightNumber;
    private Long departureAirportId;
    private String departureAirportName;
    private String departureCity;
    private Long arrivalAirportId;
    private String arrivalAirportName;
    private String arrivalCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Long planeId;
    private String planeModel;
    private Integer availableSeats;
    private Double price;
    private String flightStatus;

    // Constructors
    public FlightDTO() {
    }

    public FlightDTO(Long flightId, String flightNumber, Long departureAirportId, String departureAirportName,
                     String departureCity, Long arrivalAirportId, String arrivalAirportName, String arrivalCity,
                     LocalDateTime departureTime, LocalDateTime arrivalTime, Long planeId, String planeModel,
                     Integer availableSeats, Double price, String flightStatus) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departureAirportId = departureAirportId;
        this.departureAirportName = departureAirportName;
        this.departureCity = departureCity;
        this.arrivalAirportId = arrivalAirportId;
        this.arrivalAirportName = arrivalAirportName;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.planeId = planeId;
        this.planeModel = planeModel;
        this.availableSeats = availableSeats;
        this.price = price;
        this.flightStatus = flightStatus;
    }

    /**
     * Converts Flight entity to FlightDTO.
     *
     * @param flight the flight entity
     * @return FlightDTO representation
     */
    public static FlightDTO fromEntity(Flight flight) {
        FlightDTO dto = new FlightDTO();
        dto.setFlightId(flight.getFlightId());
        dto.setFlightNumber(flight.getFlightNumber());

        if (flight.getDepartureAirport() != null) {
            dto.setDepartureAirportId(flight.getDepartureAirport().getAirportId());
            dto.setDepartureAirportName(flight.getDepartureAirport().getAirportName());
            dto.setDepartureCity(flight.getDepartureAirport().getCity());
        }

        if (flight.getArrivalAirport() != null) {
            dto.setArrivalAirportId(flight.getArrivalAirport().getAirportId());
            dto.setArrivalAirportName(flight.getArrivalAirport().getAirportName());
            dto.setArrivalCity(flight.getArrivalAirport().getCity());
        }

        dto.setDepartureTime(flight.getDepartureTime());
        dto.setArrivalTime(flight.getArrivalTime());

        if (flight.getPlane() != null) {
            dto.setPlaneId(flight.getPlane().getPlaneId());
            dto.setPlaneModel(flight.getPlane().getModel());
        }

        dto.setAvailableSeats(flight.getAvailableSeats());
        dto.setPrice(flight.getPrice());
        dto.setFlightStatus(flight.getFlightStatus());

        return dto;
    }

    /**
     * Converts FlightDTO to Flight entity.
     *
     * @return Flight entity
     */
    public Flight toEntity() {
        Flight flight = new Flight();
        flight.setFlightId(this.flightId);
        flight.setFlightNumber(this.flightNumber);
        flight.setDepartureTime(this.departureTime);
        flight.setArrivalTime(this.arrivalTime);
        flight.setAvailableSeats(this.availableSeats);
        flight.setPrice(this.price);
        flight.setFlightStatus(this.flightStatus);
        return flight;
    }

    // Getters and Setters
    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Long getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(Long departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public Long getArrivalAirportId() {
        return arrivalAirportId;
    }

    public void setArrivalAirportId(Long arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "flightId=" + flightId +
                ", flightNumber='" + flightNumber + '\'' +
                ", departureAirportId=" + departureAirportId +
                ", departureAirportName='" + departureAirportName + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalAirportId=" + arrivalAirportId +
                ", arrivalAirportName='" + arrivalAirportName + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", planeId=" + planeId +
                ", planeModel='" + planeModel + '\'' +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                ", flightStatus='" + flightStatus + '\'' +
                '}';
    }
}
