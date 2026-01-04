package com.KORNN.airline_backend.dto;

import java.time.LocalDateTime;

import com.KORNN.airline_backend.model.Book;

/**
 * DTO for outgoing booking responses.
 * Contains booking information to be sent to clients.
 */
public class BookDTO {

    private Long reservationId;
    private Long clientId;
    private String clientName;
    private Long flightId;
    private String flightNumber;
    private String seatNumber;
    private Integer numberOfPassengers;
    private LocalDateTime bookingDate;
    private String bookingStatus;
    private Double totalPrice;

    // Constructors
    public BookDTO() {
    }

    public BookDTO(Long reservationId, Long clientId, String clientName, Long flightId,
                   String flightNumber, String seatNumber, Integer numberOfPassengers,
                   LocalDateTime bookingDate, String bookingStatus, Double totalPrice) {
        this.reservationId = reservationId;
        this.clientId = clientId;
        this.clientName = clientName;
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.numberOfPassengers = numberOfPassengers;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.totalPrice = totalPrice;
    }

    /**
     * Converts a Book entity to a BookDTO.
     * This method is called by the controller.
     *
     * @param book the booking entity
     * @return BookDTO representation
     */
    public static BookDTO fromEntity(Book book) {
        BookDTO dto = new BookDTO();
        dto.setReservationId(book.getReservationId());
        dto.setClientId(book.getClient().getClientId());
        dto.setClientName(book.getClient().getFirstName() + " " + book.getClient().getLastName());
        dto.setFlightId(book.getFlight().getFlightId());
        dto.setFlightNumber(book.getFlight().getFlightNumber());
        dto.setSeatNumber(book.getSeatNumber());
        dto.setNumberOfPassengers(book.getNumberOfPassengers());
        dto.setBookingDate(book.getBookingDate());
        dto.setBookingStatus(book.getBookingStatus());
        dto.setTotalPrice(book.getTotalPrice());
        return dto;
    }

    // Getters and Setters
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "reservationId=" + reservationId +
                ", clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", flightId=" + flightId +
                ", flightNumber='" + flightNumber + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                ", bookingDate=" + bookingDate +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
