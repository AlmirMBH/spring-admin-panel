package com.example.demo.parameters.services;

import com.example.demo.parameters.models.Country;
import com.example.demo.parameters.models.Location;
import com.example.demo.parameters.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll(){ return locationRepository.findAll(); }
    public void save(Location location){ locationRepository.save(location); }
    public Location findById(Integer id){ return locationRepository.findById(id).orElse(null); }
    public void delete(Integer id){ locationRepository.deleteById(id); }
}
