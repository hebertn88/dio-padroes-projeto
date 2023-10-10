package edu.hnascimento.diopadroesprojeto.services.impl;

import edu.hnascimento.diopadroesprojeto.models.Client;
import edu.hnascimento.diopadroesprojeto.models.ClientRepository;
import edu.hnascimento.diopadroesprojeto.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository repository;

    @Override
    public Iterable<Client> findAll() {
        return repository.findAll();
    }
}
