package com.HippyAir.hippyair_backend.repository;

import com.HippyAir.hippyair_backend.model.MilesReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilesRewardRepository extends JpaRepository<MilesReward, Long> {
    List<MilesReward> findByClientNumPassport(String numPassport);
}

