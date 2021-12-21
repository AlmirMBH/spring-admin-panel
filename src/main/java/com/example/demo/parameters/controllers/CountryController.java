package com.example.demo.parameters.controllers;

import com.example.demo.parameters.models.Country;
import com.example.demo.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;


    @GetMapping("/countries")
    // @ResponseBody // if there is no template, return array of json objects
    public String getAll(Model model){
        List<Country> countries = countryService.getAll();
        model.addAttribute("countries", countries);
        return "parameters/countryList";
    }

    @GetMapping("/countryAdd")
    public String add(){
        return "parameters/countryAdd";
    }

    @PostMapping("/countries")
    public String saveCountry(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

    @GetMapping("/countryEdit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "/parameters/countryEdit";
    }

    @RequestMapping(value = "/countries/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String editCountry(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

    // @DeleteMapping - cannot work in this context as it first invokes 'get' and then 'delete'
    @RequestMapping(value = "/country/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteCountry(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/countries";
    }

}
