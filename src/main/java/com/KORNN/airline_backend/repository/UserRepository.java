package fr.epita.timeoutairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.epita.timeoutairline.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository provides: save(), findById(), findAll(), deleteById(), etc.
}