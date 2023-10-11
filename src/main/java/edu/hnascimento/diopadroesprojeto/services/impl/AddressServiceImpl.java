package edu.hnascimento.diopadroesprojeto.services.impl;

import edu.hnascimento.diopadroesprojeto.models.Address;
import edu.hnascimento.diopadroesprojeto.models.AddressRepository;
import edu.hnascimento.diopadroesprojeto.services.AddressService;
import edu.hnascimento.diopadroesprojeto.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Optional<Address> findById(String cep){

        var addressDatabase = addressRepository.findByCep(cep);
        if (addressDatabase.isPresent()) {
            return addressDatabase;
        }

        var addressApi = viaCepService.getCep(cep);
        if (Objects.equals(addressApi.getCep(), null)) {
            return Optional.empty();
        }
        addressRepository.save(addressApi);
        return Optional.of(addressApi);
    }
}
