package com.example.demo.parameters.controllers;

import com.example.demo.parameters.models.State;
import com.example.demo.parameters.services.CountryService;
import com.example.demo.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StateController {

    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;

    //Retrieve states
    @GetMapping("/parameters/states")
    public String findAll(Model model){
        addModelAttribute(model);
        return "/parameters/states";
    }


    //Add state
    @GetMapping("/parameters/stateAdd")
    public String addState(Model model){
        addModelAttribute(model);
        return "parameters/stateAdd";
    }

    @PostMapping(value="/parameters/states")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/parameters/states";
    }


    // Edit state and state detail
    @GetMapping("/parameters/state/{operation}/{id}")
    public String editState(@PathVariable Integer id, @PathVariable String operation, Model model){
        addModelAttribute(model);
        model.addAttribute("state", stateService.findById(id));
        return "/parameters/state" + operation;
    }


    // Delete state
    @RequestMapping(value="/parameters/states/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        stateService.delete(id);
        return "redirect:/parameters/states";
    }


    // Add attributes via method
    public  Model addModelAttribute(Model model){
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return model;
    }
}
