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

    public List<Country> findAll(){ return countryRepository.findAll(); }
    public void save(Country country){ countryRepository.save(country); }
    public Country findById(Integer id){ return countryRepository.findById(id).orElse(null); }
    public void delete(Integer id){ countryRepository.deleteById(id); }

}
