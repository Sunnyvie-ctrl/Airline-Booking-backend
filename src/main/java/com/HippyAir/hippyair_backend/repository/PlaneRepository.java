package com.HippyAir.hippyair_backend.repository;

import com.HippyAir.hippyair_backend.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
