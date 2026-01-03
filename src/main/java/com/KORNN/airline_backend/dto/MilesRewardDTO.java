package com.KORNN.airline_backend.dto;

import java.time.LocalDateTime;
import java.time.Year;

import com.KORNN.airline_backend.model.MilesReward;

/**
 * DTO for MilesReward entity.
 * Used for retrieving flight history and discount codes.
 */
public class MilesRewardDTO {

    private Long milesRewardId;
    private String clientPassport;
    private String clientName;
    private Long bookingId;
    private String flightNumber;
    private LocalDateTime flightDate;
    private Year year;
    private Integer milesEarned;
    private String discountCode;

    // Constructors
    public MilesRewardDTO() {
    }

    public MilesRewardDTO(Long milesRewardId, String clientPassport, String clientName, Long bookingId,
                          String flightNumber, LocalDateTime flightDate, Year year, Integer milesEarned,
                          String discountCode) {
        this.milesRewardId = milesRewardId;
        this.clientPassport = clientPassport;
        this.clientName = clientName;
        this.bookingId = bookingId;
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.year = year;
        this.milesEarned = milesEarned;
        this.discountCode = discountCode;
    }

    /**
     * Converts MilesReward entity to MilesRewardDTO.
     *
     * @param milesReward the miles reward entity
     * @return MilesRewardDTO representation
     */
    public static MilesRewardDTO fromEntity(MilesReward milesReward) {
        MilesRewardDTO dto = new MilesRewardDTO();
        dto.setMilesRewardId(milesReward.getMilesRewardId());

        if (milesReward.getClient() != null) {
            dto.setClientPassport(milesReward.getClient().getPassportNumber());
            dto.setClientName(milesReward.getClient().getFirstName() + " " +
                    milesReward.getClient().getLastName());
        }

        if (milesReward.getBooking() != null) {
            dto.setBookingId(milesReward.getBooking().getReservationId());
            if (milesReward.getBooking().getFlight() != null) {
                dto.setFlightNumber(milesReward.getBooking().getFlight().getFlightNumber());
            }
        }

        dto.setFlightDate(milesReward.getFlightDate());
        dto.setYear(milesReward.getYear());
        dto.setMilesEarned(milesReward.getMilesEarned());
        dto.setDiscountCode(milesReward.getDiscountCode());

        return dto;
    }

    // Getters and Setters
    public Long getMilesRewardId() {
        return milesRewardId;
    }

    public void setMilesRewardId(Long milesRewardId) {
        this.milesRewardId = milesRewardId;
    }

    public String getClientPassport() {
        return clientPassport;
    }

    public void setClientPassport(String clientPassport) {
        this.clientPassport = clientPassport;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDateTime getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDateTime flightDate) {
        this.flightDate = flightDate;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Integer getMilesEarned() {
        return milesEarned;
    }

    public void setMilesEarned(Integer milesEarned) {
        this.milesEarned = milesEarned;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    @Override
    public String toString() {
        return "MilesRewardDTO{" +
                "milesRewardId=" + milesRewardId +
                ", clientPassport='" + clientPassport + '\'' +
                ", clientName='" + clientName + '\'' +
                ", bookingId=" + bookingId +
                ", flightNumber='" + flightNumber + '\'' +
                ", flightDate=" + flightDate +
                ", year=" + year +
                ", milesEarned=" + milesEarned +
                ", discountCode='" + discountCode + '\'' +
                '}';
    }
}
