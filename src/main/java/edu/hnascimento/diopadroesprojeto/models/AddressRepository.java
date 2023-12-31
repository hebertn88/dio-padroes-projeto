package edu.hnascimento.diopadroesprojeto.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    public Optional<Address> findByCep(String cep);
}
