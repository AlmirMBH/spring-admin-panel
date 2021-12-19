package com.example.demo.parameters.controllers;

import com.example.demo.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;
}
