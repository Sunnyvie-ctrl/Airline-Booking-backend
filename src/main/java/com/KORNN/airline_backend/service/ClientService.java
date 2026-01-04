package fr.epita.timeoutairline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.epita.timeoutairline.model.Client;
import fr.epita.timeoutairline.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Create
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Read all
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Read one by ID
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    // Read by passport number
    public Optional<Client> getClientByPassport(String numPassport) {
        return clientRepository.findByNumPassport(numPassport);
    }

    // Update
    public Client updateClient(Long id, Client clientDetails) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        
        client.setFirstname(clientDetails.getFirstname());
        client.setLastname(clientDetails.getLastname());
        client.setAddress(clientDetails.getAddress());
        client.setEmail(clientDetails.getEmail());
        client.setPhone(clientDetails.getPhone());
        client.setBirthdate(clientDetails.getBirthdate());
        client.setNumPassport(clientDetails.getNumPassport());
        
        return clientRepository.save(client);
    }

    // Delete
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        clientRepository.delete(client);
    }
}