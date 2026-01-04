package fr.epita.timeoutairline.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoSeatAvailableException extends RuntimeException {

    public NoSeatAvailableException(String flightNumber) {
        super(String.format("No available seats on flight: %s", flightNumber));
    }

    public NoSeatAvailableException(String flightNumber, int totalSeats, int bookedSeats) {
        super(String.format("No available seats on flight %s. Total: %d, Booked: %d", 
            flightNumber, totalSeats, bookedSeats));
    }
}