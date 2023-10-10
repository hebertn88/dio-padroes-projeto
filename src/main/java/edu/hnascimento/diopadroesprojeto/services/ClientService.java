package edu.hnascimento.diopadroesprojeto.services;

import edu.hnascimento.diopadroesprojeto.models.Client;

public interface ClientService {
    Iterable<Client> findAll();
}
