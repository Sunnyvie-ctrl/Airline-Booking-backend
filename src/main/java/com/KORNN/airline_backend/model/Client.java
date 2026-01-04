
package fr.epita.timeoutairline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends User {

    @Column(unique = true) // adds unique constraint to the column passport num
    private String numPassport;

    // Default constructor (required by JPA)  because it needs it to be able to create objects with reflection
    public Client() {
    }  // it must be able to call a no-argument constructor 

    // Constructor with all fields (including parent fields)
    public Client(String firstname, String lastname, String address, String email, String phone, java.time.LocalDate birthdate, String numPassport) {
        super(firstname, lastname, address, email, phone, birthdate);  // Call parent constructor
        this.numPassport = numPassport;
    }

    // Getter and Setter
    public String getNumPassport() {
        return numPassport;
    }

    public void setNumPassport(String numPassport) {
        this.numPassport = numPassport;
    }
}