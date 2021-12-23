package com.example.demo.parameters.services;

import com.example.demo.parameters.models.Contact;
import com.example.demo.parameters.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll(){ return contactRepository.findAll(); }
    public void save(Contact contact){ contactRepository.save(contact); }
    public Contact findById(Integer id){ return contactRepository.findById(id).orElse(null); }
    public void delete(Integer id){ contactRepository.deleteById(id); }
}
