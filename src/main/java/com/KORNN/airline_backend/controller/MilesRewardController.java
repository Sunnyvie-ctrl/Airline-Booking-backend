package com.KORNN.airline_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.KORNN.airline_backend.model.MilesReward;
import com.KORNN.airline_backend.service.MilesRewardService;

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
