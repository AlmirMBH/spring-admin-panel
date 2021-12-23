package com.example.demo.parameters.services;

import com.example.demo.parameters.models.Client;
import com.example.demo.parameters.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){ return clientRepository.findAll(); }
    public void save(Client client){ clientRepository.save(client); }
    public Client findById(Integer id){ return clientRepository.findById(id).orElse(null); }
    public void delete(Integer id){ clientRepository.deleteById(id); }
}
