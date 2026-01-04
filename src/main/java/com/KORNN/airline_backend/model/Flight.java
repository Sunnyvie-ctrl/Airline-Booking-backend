package fr.epita.timeoutairline.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    private String flightNumber;

    private String departureCity;
    private String arrivalCity;
    private String departureHour;
    private String arrivalHour;
    private LocalDate departureDate;
    private int numberOfSeat;
    private BigDecimal firstClassSeatPrice;
    private BigDecimal premiumSeatPrice;
    private BigDecimal businessClassPrice;
    private BigDecimal economicsClassPrice;

    @ManyToOne   /// many flights can use 1 plane
    @JoinColumn(name = "id_plane")   /// the flight table will have a column Id_plane... joined from the plane table
    private Plane plane;   

    @ManyToOne  // many flights can have same departure airport
    @JoinColumn(name = "departure_airport_id")  // departure_airport_id is a foreign key in flights table
    private Airport departureAirport; //

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    // Default constructor
    public Flight() {
    }

    // Constructor with fields
    public Flight(String flightNumber, String departureCity, String arrivalCity,
                  String departureHour, String arrivalHour, LocalDate departureDate,
                  int numberOfSeat, BigDecimal firstClassSeatPrice, BigDecimal premiumSeatPrice,
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

    public String getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(String departureHour) {
        this.departureHour = departureHour;
    }

    public String getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(String arrivalHour) {
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