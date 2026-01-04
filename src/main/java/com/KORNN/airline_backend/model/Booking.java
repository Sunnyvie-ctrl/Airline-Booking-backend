package fr.epita.timeoutairline.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto_increment
    private Long idReservation;

    @ManyToOne // many bookings can have same flight number 
    @JoinColumn(name = "flight_number")  // flight number is a foreign key added to booking
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.STRING) // this tells JPA how to store the enum 
    private SeatType typeOfSeat;

    private LocalDateTime bookingDate;

    // Enum for seat types   -- a fixed set of allowed values 
    public enum SeatType {
        FIRST_CLASS,
        PREMIUM,
        BUSINESS,
        ECONOMICS
    }

    // Default constructor
    public Booking() {
        this.bookingDate = LocalDateTime.now();   /// why the defaukt constructor is not empty... when hibernate creates booking 
        //and calls the default constructor, the bookingDate will be filled autoamtically
    }

    // Constructor with fields
    public Booking(Flight flight, Client client, SeatType typeOfSeat) {
        this.flight = flight;
        this.client = client;
        this.typeOfSeat = typeOfSeat;
        this.bookingDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public SeatType getTypeOfSeat() {
        return typeOfSeat;
    }

    public void setTypeOfSeat(SeatType typeOfSeat) {
        this.typeOfSeat = typeOfSeat;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}