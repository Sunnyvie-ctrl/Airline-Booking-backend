package fr.epita.timeoutairline.dto;

import fr.epita.timeoutairline.model.Booking.SeatType;
import java.time.LocalDate;

public class BookingRequest {

    private String lastname;
    private String firstname;
    private String email;  // ADD THIS
    private String passportNumber;
    private LocalDate birthdate;
    private String departureCity;
    private String arrivalCity;
    private String departureHour;
    private String arrivalHour;
    private String flightNumber;
    private SeatType typeOfSeat;

    public BookingRequest() {
    }

    // ADD getter and setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters and Setters
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public SeatType getTypeOfSeat() {
        return typeOfSeat;
    }

    public void setTypeOfSeat(SeatType typeOfSeat) {
        this.typeOfSeat = typeOfSeat;
    }
}