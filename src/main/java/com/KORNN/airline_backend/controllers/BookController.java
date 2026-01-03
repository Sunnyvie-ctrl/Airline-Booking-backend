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

    @PostMapping
    public ResponseEntity<BookDTO> bookFlight(@RequestBody BookingRequest request) {
        Book booking = bookingService.bookFlight(request);
        return ResponseEntity.ok(BookDTO.fromEntity(booking));
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<BookDTO> getBooking(@PathVariable Long reservationId) {
        Book booking = bookingService.getBooking(reservationId);
        return ResponseEntity.ok(BookDTO.fromEntity(booking));
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long reservationId) {
        bookingService.cancelBooking(reservationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBookings() {
        List<BookDTO> bookings = bookingService.getAllBookings()
                .stream()
                .map(BookDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookings);
    }
}
