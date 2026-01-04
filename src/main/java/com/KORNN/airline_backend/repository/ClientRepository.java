package fr.epita.timeoutairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.epita.timeoutairline.model.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    // Custom method: find client by passport number
    Optional<Client> findByNumPassport(String numPassport);
}