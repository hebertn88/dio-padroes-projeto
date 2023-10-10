package edu.hnascimento.diopadroesprojeto.controllers;

import edu.hnascimento.diopadroesprojeto.models.Client;
import edu.hnascimento.diopadroesprojeto.models.ClientRepository;
import edu.hnascimento.diopadroesprojeto.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }


}
