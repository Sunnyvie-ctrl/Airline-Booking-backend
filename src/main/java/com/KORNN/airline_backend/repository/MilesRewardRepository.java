package fr.epita.timeoutairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import fr.epita.timeoutairline.model.Client;
import fr.epita.timeoutairline.model.MilesReward;

import java.util.List;

@Repository
public interface MilesRewardRepository extends JpaRepository<MilesReward, Long> {

    // Find all miles rewards for a client
    List<MilesReward> findByClient(Client client);

    // Count flights for a client in a specific year
    @Query("SELECT COUNT(m) FROM MilesReward m WHERE m.client = :client AND YEAR(m.date) = :year")
    int countFlightsByClientAndYear(@Param("client") Client client, @Param("year") int year);
}