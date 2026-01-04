package fr.epita.timeoutairline.model;

import jakarta.persistence.*;   // Imports all JPA annotations (@Entity, @Table, @Column, etc.) so we can map this class to a database table.
import java.time.LocalDate;

@Entity // tells jpa its a db table, create one if it doesn't exist
@Table(name = "users")   // names the table user
@Inheritance(strategy = InheritanceType.JOINED)  // this shows that this is the parent table plus all child table joined by a foreign key
public class User {

    @Id  // specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment id
    private Long idUser;

    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phone;
    private LocalDate birthdate;

    // Default constructor (required by JPA)
    public User() {
    }
    /**
     * 
     * @param firstname
     * @param lastname
     * @param address
     * @param email
     * @param phone
     * @param birthdate
     */

    // Constructor with fields
    public User(String firstname, String lastname, String address, String email, String phone, LocalDate birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.birthdate = birthdate;
    }

    // Getters and Setters
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}