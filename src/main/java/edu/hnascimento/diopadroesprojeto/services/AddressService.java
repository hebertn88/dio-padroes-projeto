package edu.hnascimento.diopadroesprojeto.services;

import edu.hnascimento.diopadroesprojeto.models.Address;

import java.util.Optional;

public interface AddressService {
    Optional<Address> findById(String cep);
}
