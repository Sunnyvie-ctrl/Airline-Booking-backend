package fr.epita.timeoutairline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fr.epita.timeoutairline.model.MilesReward;
import fr.epita.timeoutairline.service.MilesRewardService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/miles-rewards")
public class MilesRewardController {

    @Autowired
    private MilesRewardService milesRewardService;

    // READ ALL - GET /api/v1/miles-rewards
    @GetMapping
    public List<MilesReward> getAllMilesRewards() {
        return milesRewardService.getAllMilesRewards();
    }
}
