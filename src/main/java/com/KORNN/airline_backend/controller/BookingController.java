package fr.epita.timeoutairline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fr.epita.timeoutairline.model.Booking;
import fr.epita.timeoutairline.service.BookingService;
import fr.epita.timeoutairline.dto.BookingRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // CREATE - POST /api/v1/bookings
    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        try {
            Booking savedBooking = bookingService.createBooking(booking);
            return ResponseEntity.ok(savedBooking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // BOOK FLIGHT (Feature #7) - POST /api/v1/bookings/book
    @PostMapping("/book")
    public ResponseEntity<?> bookFlight(@RequestBody BookingRequest request) {
        try {
            Booking savedBooking = bookingService.createBookingFromRequest(request);
            return ResponseEntity.ok(savedBooking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // READ ALL - GET /api/v1/bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // READ ONE - GET /api/v1/bookings/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // GET AVAILABLE SEATS - GET /api/v1/bookings/available-seats/{flightNumber}
    @GetMapping("/available-seats/{flightNumber}")
    public ResponseEntity<?> getAvailableSeats(@PathVariable String flightNumber) {
        try {
            int availableSeats = bookingService.getAvailableSeats(flightNumber);
            return ResponseEntity.ok("Available seats: " + availableSeats);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // UPDATE - PUT /api/v1/bookings/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
        try {
            Booking updatedBooking = bookingService.updateBooking(id, bookingDetails);
            return ResponseEntity.ok(updatedBooking);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - DELETE /api/v1/bookings/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        try {
            bookingService.deleteBooking(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}