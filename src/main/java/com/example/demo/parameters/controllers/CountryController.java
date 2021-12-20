package com.example.demo.parameters.controllers;

import com.example.demo.parameters.models.Country;
import com.example.demo.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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



}
