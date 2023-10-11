package edu.hnascimento.diopadroesprojeto.controllers;

import edu.hnascimento.diopadroesprojeto.models.Client;
import edu.hnascimento.diopadroesprojeto.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> findAll() {
        var clients = clientService.findAll();

        var sizeClients = ((Collection<Client>) clients).size();

        if (sizeClients == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> findById(@PathVariable Long id) {
        var client = clientService.findById(id);

        if (client.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(client);

    }

    @PostMapping
    public ResponseEntity<Optional<Client>> create(@RequestBody Client client) {
        var newClient = clientService.create(client);

        if (newClient.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(newClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Client>> update(@PathVariable Long id, @RequestBody Client client) {
        var updatedClient = clientService.update(id, client);

        if (updatedClient.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Client>> delete(@PathVariable Long id) {
        var deletedClient = clientService.delete(id);

        if (deletedClient.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(deletedClient);
    }


}
