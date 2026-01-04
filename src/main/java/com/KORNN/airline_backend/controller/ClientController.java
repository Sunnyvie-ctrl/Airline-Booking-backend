package com.KORNN.airline_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.KORNN.airline_backend.model.Client;
import com.KORNN.airline_backend.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // CREATE - POST /api/v1/clients
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    // READ ALL - GET /api/v1/clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // READ ONE - GET /api/v1/clients/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // READ BY PASSPORT - GET /api/v1/clients/passport/{numPassport}
    @GetMapping("/passport/{numPassport}")
    public ResponseEntity<Client> getClientByPassport(@PathVariable String numPassport) {
        return clientService.getClientByPassport(numPassport)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - PUT /api/v1/clients/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        try {
            Client updatedClient = clientService.updateClient(id, clientDetails);
            return ResponseEntity.ok(updatedClient);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - DELETE /api/v1/clients/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}