package edu.hnascimento.diopadroesprojeto.controllers;

import edu.hnascimento.diopadroesprojeto.models.Address;
import edu.hnascimento.diopadroesprojeto.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("/{cep}")
    public ResponseEntity<Object> findByCep(@PathVariable String cep) {
        try {
            return ResponseEntity.ok(addressService.findById(cep));
        } catch (Exception e) {
            return ResponseEntity.ok().build();
        }

    }
}
