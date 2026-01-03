package com.KORNN.airline_backend.controllers;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KORNN.airline_backend.dto.MilesRewardDTO;
import com.KORNN.airline_backend.model.MilesReward;
import com.KORNN.airline_backend.service.MilesRewardService;

/**
 * REST controller responsible for MilesReward management.
 *
 * Responsibilities:
 * - Retrieve flight history for a client
 * - Check yearly flight count
 * - Retrieve discount codes if applicable
 *
 * Business rules:
 * - Every booking creates a MilesReward entry
 * - If a client completes 3 flights within the same civil year,
 *   a random discount code is generated
 *
 * Notes:
 * - MilesReward creation is AUTOMATIC during booking
 * - This controller is READ-ONLY for clients
 */
@RestController
@RequestMapping("/api/miles-rewards")
public class MilesRewardController {

    private final MilesRewardService milesRewardService;

    public MilesRewardController(MilesRewardService milesRewardService) {
        this.milesRewardService = milesRewardService;
    }

    /**
     * Retrieves all MilesReward records for a given client.
     *
     * @param passport Client passport number
     * @return list of MilesReward entries
     */
    @GetMapping("/client/{passport}")
    public ResponseEntity<List<MilesRewardDTO>> getRewardsByClient(
            @PathVariable String passport) {

        List<MilesRewardDTO> rewards = milesRewardService
                .getRewardsByClient(passport)
                .stream()
                .map(MilesRewardDTO::fromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(rewards);
    }

    /**
     * Retrieves MilesReward entries for a client for a specific civil year.
     *
     * @param passport Client passport number
     * @param year Civil year (e.g., 2025)
     * @return list of MilesReward entries for the year
     */
    @GetMapping("/client/{passport}/year/{year}")
    public ResponseEntity<List<MilesRewardDTO>> getRewardsByClientAndYear(
            @PathVariable String passport,
            @PathVariable int year) {

        List<MilesRewardDTO> rewards = milesRewardService
                .getRewardsByClientAndYear(passport, Year.of(year))
                .stream()
                .map(MilesRewardDTO::fromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(rewards);
    }

    /**
     * Checks whether a client is eligible for a discount code.
     *
     * @param passport Client passport number
     * @param year Civil year
     * @return discount code if eligible, otherwise null
     */
    @GetMapping("/client/{passport}/discount/{year}")
    public ResponseEntity<String> getDiscountCode(
            @PathVariable String passport,
            @PathVariable int year) {

        String discountCode = milesRewardService
                .getDiscountCodeIfEligible(passport, Year.of(year));

        return ResponseEntity.ok(discountCode);
    }
}
