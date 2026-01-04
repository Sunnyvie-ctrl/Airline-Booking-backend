package fr.epita.timeoutairline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.epita.timeoutairline.model.*;
import fr.epita.timeoutairline.repository.*;
import fr.epita.timeoutairline.dto.BookingRequest;
import fr.epita.timeoutairline.exception.ResourceNotFoundException;
import fr.epita.timeoutairline.exception.NoSeatAvailableException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MilesRewardRepository milesRewardRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ClientRepository clientRepository;

    // Create booking with seat availability check and miles reward
    public Booking createBooking(Booking booking) {
        Flight flight = booking.getFlight(); // gets flights from booking :: since the booking coming from booking controller contains a flight reference

        // Check if flight exists
        Flight existingFlight = flightRepository.findById(flight.getFlightNumber())
            .orElseThrow(() -> new ResourceNotFoundException("Flight", "flightNumber", flight.getFlightNumber()));

        // Check seat availability
        int bookedSeats = bookingRepository.countByFlight(existingFlight);
        if (bookedSeats >= existingFlight.getNumberOfSeat()) {
            throw new NoSeatAvailableException(existingFlight.getFlightNumber(), 
                existingFlight.getNumberOfSeat(), bookedSeats);
        }

        // Set the actual flight object
        booking.setFlight(existingFlight);

        // Save booking
        Booking savedBooking = bookingRepository.save(booking);

        // Record in MilesReward
        recordMilesReward(booking.getClient(), existingFlight);

        return savedBooking;
    }

    // Create booking from BookingRequest DTO (Feature #7)
    public Booking createBookingFromRequest(BookingRequest request) {
        // Find or create client by passport number
        Client client = clientRepository.findByNumPassport(request.getPassportNumber())
            .orElseGet(() -> {
                // Create new client if not exists
                Client newClient = new Client();
                newClient.setFirstname(request.getFirstname());
                newClient.setLastname(request.getLastname());
                newClient.setNumPassport(request.getPassportNumber());
                newClient.setEmail(request.getEmail());
                newClient.setBirthdate(request.getBirthdate());
                return clientRepository.save(newClient);
            });

        // Find flight
        Flight flight = flightRepository.findById(request.getFlightNumber())
            .orElseThrow(() -> new ResourceNotFoundException("Flight", "flightNumber", request.getFlightNumber()));

        // Check seat availability
        int bookedSeats = bookingRepository.countByFlight(flight);
        if (bookedSeats >= flight.getNumberOfSeat()) {
            throw new NoSeatAvailableException(flight.getFlightNumber(), 
                flight.getNumberOfSeat(), bookedSeats);
        }

        // Create booking
        Booking booking = new Booking(flight, client, request.getTypeOfSeat());
        Booking savedBooking = bookingRepository.save(booking);

        // Record in MilesReward
        recordMilesReward(client, flight);

        return savedBooking;
    }

    // Record miles reward and check for discount
    private void recordMilesReward(Client client, Flight flight) {
        MilesReward milesReward = new MilesReward(client, flight);

        // Count flights this year
        int currentYear = LocalDate.now().getYear();
        int flightsThisYear = milesRewardRepository.countFlightsByClientAndYear(client, currentYear);

        // If this is the 3rd flight (or multiple of 3), generate discount code
        if ((flightsThisYear + 1) % 3 == 0) {
            String discountCode = generateDiscountCode();
            milesReward.setDiscountCode(discountCode);
        }

        milesRewardRepository.save(milesReward);
    }

    // Generate random discount code
    private String generateDiscountCode() {
        return "DISC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    // Read all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Read booking by ID
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    // Read bookings by client
    public List<Booking> getBookingsByClient(Client client) {
        return bookingRepository.findByClient(client);
    }

    // Read bookings by flight
    public List<Booking> getBookingsByFlight(Flight flight) {
        return bookingRepository.findByFlight(flight);
    }

    // Update booking
    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));

        booking.setFlight(bookingDetails.getFlight());
        booking.setClient(bookingDetails.getClient());
        booking.setTypeOfSeat(bookingDetails.getTypeOfSeat());

        return bookingRepository.save(booking);
    }

    // Delete booking
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));
        bookingRepository.delete(booking);
    }

    // Get available seats for a flight
    public int getAvailableSeats(String flightNumber) {
        Flight flight = flightRepository.findById(flightNumber)
            .orElseThrow(() -> new ResourceNotFoundException("Flight", "flightNumber", flightNumber));

        int bookedSeats = bookingRepository.countByFlight(flight);
        return flight.getNumberOfSeat() - bookedSeats;
    }
}