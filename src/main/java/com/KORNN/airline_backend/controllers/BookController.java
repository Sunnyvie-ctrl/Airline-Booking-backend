package com.KORNN.airline_backend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KORNN.airline_backend.dto.BookingRequest;
import com.KORNN.airline_backend.dto.BookDTO;
import com.KORNN.airline_backend.model.Book;
import com.KORNN.airline_backend.service.BookingService;

/**
 * REST controller for flight bookings.
 *
 * Responsibilities:
 * - Book flights for clients
 * - Cancel or retrieve bookings
 * - Uses DTOs for input/output
 */
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Books a flight for a client.
     *
     * <p>Business rules:</p>
     * <ul>
     *   <li>Seat availability is checked</li>
     *   <li>MilesReward entry is created</li>
     *   <li>A discount code may be generated after 3 flights in a year</li>
     * </ul>
     *
     * @param request booking request data
     * @return created booking
     */
    @PostMapping
    public ResponseEntity<BookDTO> bookFlight(@RequestBody BookingRequest request) {
        Book booking = bookingService.bookFlight(request);
        return ResponseEntity.ok(BookDTO.fromEntity(booking));
    }

    /**
     * Retrieves booking by ID
     * 
     * @return booking
     */
    @GetMapping("/{reservationId}")
    public ResponseEntity<BookDTO> getBooking(@PathVariable Long reservationId) {
        Book booking = bookingService.getBooking(reservationId);
        return ResponseEntity.ok(BookDTO.fromEntity(booking));
    }

    /**
     * Deletes an airport.
     *
     * @param id booking ID
     * @return empty response
     */
    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long reservationId) {
        bookingService.cancelBooking(reservationId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Retrieves all booking
     * 
     * @return all booking
     */
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBookings() {
        List<BookDTO> bookings = bookingService.getAllBookings()
                .stream()
                .map(BookDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookings);
    }
}
