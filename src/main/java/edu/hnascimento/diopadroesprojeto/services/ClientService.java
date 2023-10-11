package edu.hnascimento.diopadroesprojeto.services;

import edu.hnascimento.diopadroesprojeto.models.Client;

import java.util.Optional;

public interface ClientService {
    Iterable<Client> findAll();

    Optional<Client> findById(Long id);

    Optional<Client> create(Client client);

    Optional<Client> update(Long id, Client client);

    void delete(Long id);
}
