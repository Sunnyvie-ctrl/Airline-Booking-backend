package com.KORNN.airline_backend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.KORNN.airline_backend.dto.ClientDTO;
import com.KORNN.airline_backend.model.Client;
import com.KORNN.airline_backend.service.ClientService;

/**
 * REST controller for Client management.
 *
 * Responsibilities:
 * - CRUD operations
 * - Clients linked to Users
 * - Uses DTOs for input/output
 */
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<ClientDTO> createClient(@PathVariable Long userId,
                                                  @RequestBody ClientDTO dto) {
        Client client = clientService.createClient(userId, dto.toEntity());
        return ResponseEntity.ok(ClientDTO.fromEntity(client));
    }

    @GetMapping("/{passport}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable String passport) {
        Client client = clientService.getClientByPassport(passport);
        return ResponseEntity.ok(ClientDTO.fromEntity(client));
    }

    @PutMapping("/{passport}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable String passport,
                                                  @RequestBody ClientDTO dto) {
        Client updated = clientService.updateClient(passport, dto.toEntity());
        return ResponseEntity.ok(ClientDTO.fromEntity(updated));
    }

    @DeleteMapping("/{passport}")
    public ResponseEntity<Void> deleteClient(@PathVariable String passport) {
        clientService.deleteClient(passport);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> clients = clientService.getAllClients()
                .stream()
                .map(ClientDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clients);
    }
}
