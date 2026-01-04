package com.KORNN.airline_backend.dto;

import com.KORNN.airline_backend.model.Client;

/**
 * DTO for Client entity.
 * Used for client CRUD operations.
 */
public class ClientDTO {

    private Long clientId;
    private String passportNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Long userId;

    // Constructors
    public ClientDTO() {
    }

    public ClientDTO(Long clientId, String passportNumber, String firstName, String lastName,
                     String email, String phoneNumber, String address, Long userId) {
        this.clientId = clientId;
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userId = userId;
    }

    /**
     * Converts Client entity to ClientDTO.
     *
     * @param client the client entity
     * @return ClientDTO representation
     */
    public static ClientDTO fromEntity(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setClientId(client.getClientId());
        dto.setPassportNumber(client.getPassportNumber());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setEmail(client.getEmail());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setAddress(client.getAddress());
        if (client.getUser() != null) {
            dto.setUserId(client.getUser().getUserId());
        }
        return dto;
    }

    /**
     * Converts ClientDTO to Client entity.
     *
     * @return Client entity
     */
    public Client toEntity() {
        Client client = new Client();
        client.setClientId(this.clientId);
        client.setPassportNumber(this.passportNumber);
        client.setFirstName(this.firstName);
        client.setLastName(this.lastName);
        client.setEmail(this.email);
        client.setPhoneNumber(this.phoneNumber);
        client.setAddress(this.address);
        return client;
    }

    // Getters and Setters
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "clientId=" + clientId +
                ", passportNumber='" + passportNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", userId=" + userId +
                '}';
    }
}