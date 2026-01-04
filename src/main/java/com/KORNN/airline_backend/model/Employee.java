package fr.epita.timeoutairline.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee extends User {

    @Column(unique = true)
    private String numEmp;

    private String profession;
    private String title;

    // Default constructor (required by JPA)
    public Employee() {
    }

    // Constructor with all fields
    public Employee(String firstname, String lastname, String address, String email, String phone, LocalDate birthdate, String numEmp, String profession, String title) {
        super(firstname, lastname, address, email, phone, birthdate);
        this.numEmp = numEmp;
        this.profession = profession;
        this.title = title;
    }

    // Getters and Setters
    public String getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(String numEmp) {
        this.numEmp = numEmp;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}