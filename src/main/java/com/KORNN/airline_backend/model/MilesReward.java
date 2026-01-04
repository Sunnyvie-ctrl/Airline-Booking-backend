
package fr.epita.timeoutairline.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "miles_rewards")
public class MilesReward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // many rewards can go to a client
    @JoinColumn(name = "client_id")  // foreign key here
    private Client client;

    @ManyToOne // many rewards can occur for same flight
    @JoinColumn(name = "flight_number")
    private Flight flight;

    private LocalDate date;

    private String discountCode;

    // Default constructor
    public MilesReward() {
        this.date = LocalDate.now();
    }

    // Constructor with fields
    public MilesReward(Client client, Flight flight) {
        this.client = client;
        this.flight = flight;
        this.date = LocalDate.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
}