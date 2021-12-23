package com.example.demo.parameters.controllers;

import com.example.demo.parameters.models.State;
import com.example.demo.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StateController {

    @Autowired private StateService stateService;

    @GetMapping("/states")
    public String findAll(Model model){
        List<State> states = stateService.findAll();
        model.addAttribute("states", states);
        return "parameters/states";
    }

    @GetMapping("/stateAdd")
    public String addState(){
        return "parameters/stateAdd";
    }

    @PostMapping("/states")
    public String saveState(State state){
        stateService.save(state);
        return "redirect:/states";
    }

    @GetMapping("/stateEdit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        State state = stateService.findById(id);
        model.addAttribute("state", state);
        return "/parameters/stateEdit";
    }

    @RequestMapping(value = "/states/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String editState(State state){
        stateService.save(state);
        return "redirect:/states";
    }

    // @DeleteMapping - cannot work in this context as it first invokes 'get' and then 'delete'
    @RequestMapping(value = "/state/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteState(@PathVariable Integer id){
        stateService.delete(id);
        return "redirect:/states";
    }

    @GetMapping("/stateDetails/{id}")
    public String detailsState(@PathVariable Integer id, Model model){
        State state = stateService.findById(id);
        model.addAttribute("state", state);
        return "/parameters/stateDetails";
    }
}
