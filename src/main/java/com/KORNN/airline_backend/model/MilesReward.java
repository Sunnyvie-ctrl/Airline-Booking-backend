
package com.KORNN.airline_backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "miles_rewards")
public class MilesReward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_miles_reward")
    private Long id;

    /** Many rewards can belong to one client */
    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    /** Many rewards can be linked to the same flight */
    @ManyToOne
    @JoinColumn(name = "flight_number", nullable = false)
    private Flight flight;

    @Column(name = "reward_date", nullable = false)
    private LocalDate date;

    @Column(name = "discount_code", unique = true)
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