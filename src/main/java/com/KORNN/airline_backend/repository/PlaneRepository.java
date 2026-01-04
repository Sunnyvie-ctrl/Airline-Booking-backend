package fr.epita.timeoutairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.epita.timeoutairline.model.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
}