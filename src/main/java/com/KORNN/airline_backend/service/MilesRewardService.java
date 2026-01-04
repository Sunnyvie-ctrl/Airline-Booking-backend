package fr.epita.timeoutairline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.epita.timeoutairline.model.Client;
import fr.epita.timeoutairline.model.MilesReward;
import fr.epita.timeoutairline.repository.MilesRewardRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class MilesRewardService {

    @Autowired
    private MilesRewardRepository milesRewardRepository;

    // Get all miles rewards
    public List<MilesReward> getAllMilesRewards() {
        return milesRewardRepository.findAll();
    }

    // Get miles rewards by client
    public List<MilesReward> getMilesRewardsByClient(Client client) {
        return milesRewardRepository.findByClient(client);
    }

    // Get flight count for client this year
    public int getFlightCountThisYear(Client client) {
        int currentYear = LocalDate.now().getYear();
        return milesRewardRepository.countFlightsByClientAndYear(client, currentYear);
    }

    // Get all discount codes for a client
    public List<String> getDiscountCodesForClient(Client client) {
        return milesRewardRepository.findByClient(client).stream()
            .map(MilesReward::getDiscountCode)
            .filter(code -> code != null)
            .toList();
    }
}