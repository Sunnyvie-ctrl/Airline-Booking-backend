package com.KORNN.airline_backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "departure_city", nullable = false)
    private String departureCity;

    @Column(name = "arrival_city", nullable = false)
    private String arrivalCity;

    @Column(name = "departure_hour", nullable = false)
    private LocalTime departureHour;

    @Column(name = "arrival_hour", nullable = false)
    private LocalTime arrivalHour;

    @Column(name = "departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name = "number_of_seat")
    private Integer numberOfSeat;

    @Column(name = "first_class_seat_price")
    private BigDecimal firstClassSeatPrice;

    @Column(name = "premium_seat_price")
    private BigDecimal premiumSeatPrice;

    @Column(name = "business_class_price")
    private BigDecimal businessClassPrice;

    @Column(name = "economics_class_price")
    private BigDecimal economicsClassPrice;

    /** Many flights can use one plane */
    @ManyToOne
    @JoinColumn(name = "id_plane", nullable = false)
    private Plane plane;

    /** Many flights can share the same departure airport */
    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    /** Many flights can share the same arrival airport */
    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;

    // Default constructor
    public Flight() {
    }

    // Full constructor
    public Flight(String flightNumber, String departureCity, String arrivalCity,
                  LocalTime departureHour, LocalTime arrivalHour, LocalDate departureDate,
                  Integer numberOfSeat, BigDecimal firstClassSeatPrice, BigDecimal premiumSeatPrice,
                  BigDecimal businessClassPrice, BigDecimal economicsClassPrice,
                  Plane plane, Airport departureAirport, Airport arrivalAirport) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureHour = departureHour;
        this.arrivalHour = arrivalHour;
        this.departureDate = departureDate;
        this.numberOfSeat = numberOfSeat;
        this.firstClassSeatPrice = firstClassSeatPrice;
        this.premiumSeatPrice = premiumSeatPrice;
        this.businessClassPrice = businessClassPrice;
        this.economicsClassPrice = economicsClassPrice;
        this.plane = plane;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }


    // Getters and Setters
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

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

    public LocalTime getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(LocalTime departureHour) {
        this.departureHour = departureHour;
    }

    public LocalTime getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(LocalTime arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public BigDecimal getFirstClassSeatPrice() {
        return firstClassSeatPrice;
    }

    public void setFirstClassSeatPrice(BigDecimal firstClassSeatPrice) {
        this.firstClassSeatPrice = firstClassSeatPrice;
    }

    public BigDecimal getPremiumSeatPrice() {
        return premiumSeatPrice;
    }

    public void setPremiumSeatPrice(BigDecimal premiumSeatPrice) {
        this.premiumSeatPrice = premiumSeatPrice;
    }

    public BigDecimal getBusinessClassPrice() {
        return businessClassPrice;
    }

    public void setBusinessClassPrice(BigDecimal businessClassPrice) {
        this.businessClassPrice = businessClassPrice;
    }

    public BigDecimal getEconomicsClassPrice() {
        return economicsClassPrice;
    }

    public void setEconomicsClassPrice(BigDecimal economicsClassPrice) {
        this.economicsClassPrice = economicsClassPrice;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}