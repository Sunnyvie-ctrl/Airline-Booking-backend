package com.KORNN.airline_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.KORNN.airline_backend.model.Booking;
import com.KORNN.airline_backend.model.Client;
import com.KORNN.airline_backend.model.Flight;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Count bookings for a specific flight (to check seat availability)
    int countByFlight(Flight flight);

    // Find all bookings by client
    List<Booking> findByClient(Client client);

    // Find all bookings for a flight
    List<Booking> findByFlight(Flight flight);
}