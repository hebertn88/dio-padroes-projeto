package edu.hnascimento.diopadroesprojeto.services.impl;

import edu.hnascimento.diopadroesprojeto.models.Address;
import edu.hnascimento.diopadroesprojeto.models.Client;
import edu.hnascimento.diopadroesprojeto.models.ClientRepository;
import edu.hnascimento.diopadroesprojeto.services.AddressService;
import edu.hnascimento.diopadroesprojeto.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressService addressService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> create(Client client) {
        return saveClientAndAddress(client);
    }

    @Override
    public Optional<Client> update(Long id, Client client) {
        Optional<Client> foundClient = this.findById(id);

        if (foundClient.isPresent() && Objects.equals(client.getId(), id)) {
            Optional<Client> updatedClient = saveClientAndAddress(client);
            if (updatedClient.isPresent()) {
                return updatedClient;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Client> delete(Long id) {
        var client = this.findById(id);
        client.ifPresent((c) -> clientRepository.deleteById(c.getId()));
        return client;
    }

    private Optional<Client> saveClientAndAddress(Client client) throws InvalidParameterException {
            String cep = client.getAddress().getCep();
            Optional<Address> address = addressService.findById(cep);

            if (address.isPresent()) {
                client.setAddress(address.get());
                return Optional.of(clientRepository.save(client));
            }

            return Optional.empty();
        }
    }