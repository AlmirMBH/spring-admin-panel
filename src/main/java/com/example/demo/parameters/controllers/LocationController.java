package com.example.demo.parameters.controllers;

import com.example.demo.parameters.models.Location;
import com.example.demo.parameters.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public String findAll(Model model){
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        return "parameters/locations";
    }

    @GetMapping("/locationAdd")
    public String addLocation(){
        return "parameters/locationAdd";
    }

    @PostMapping("/locations")
    public String saveLocation(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @GetMapping("/locationEdit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Location location = locationService.findById(id);
        model.addAttribute("location", location);
        return "/parameters/locationEdit";
    }

    @RequestMapping(value = "/locations/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String editLocation(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    // @DeleteMapping - cannot work in this context as it first invokes 'get' and then 'delete'
    @RequestMapping(value = "/location/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteLocation(@PathVariable Integer id){
        locationService.delete(id);
        return "redirect:/locations";
    }

    @GetMapping("/locationDetails/{id}")
    public String detailsLocation(@PathVariable Integer id, Model model){
        Location location = locationService.findById(id);
        model.addAttribute("location", location);
        return "/parameters/locationDetails";
    }
}
