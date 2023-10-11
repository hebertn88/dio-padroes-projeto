package edu.hnascimento.diopadroesprojeto.services;

import edu.hnascimento.diopadroesprojeto.models.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    Address getCep(@PathVariable("cep") String cep);
}
