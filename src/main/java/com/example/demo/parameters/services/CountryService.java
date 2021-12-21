package com.example.demo.parameters.services;

import com.example.demo.parameters.models.Country;
import com.example.demo.parameters.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAll(){ return countryRepository.findAll(); }
    public void save(Country country){ countryRepository.save(country); }
    public Country getById(Integer id){ return countryRepository.findById(id).orElse(null); }
//    public void update(Integer id){ countryRepository.save (id); }
    public void delete(Integer id){ countryRepository.deleteById(id); }

}
