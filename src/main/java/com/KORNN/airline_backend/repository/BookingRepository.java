package fr.epita.timeoutairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.epita.timeoutairline.model.Booking;
import fr.epita.timeoutairline.model.Client;
import fr.epita.timeoutairline.model.Flight;

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