package com.example.demo.parameters.controllers;

import com.example.demo.parameters.models.Client;
import com.example.demo.parameters.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired private ClientService clientService;

    @GetMapping("/clients")
    public String findAll(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "parameters/clients";
    }

    @GetMapping("/clientAdd")
    public String addClient(){
        return "parameters/clientAdd";
    }

    @PostMapping("/clients")
    public String saveClient(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/clientEdit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "/parameters/clientEdit";
    }

    @RequestMapping(value = "/clients/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String editClient(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    // @DeleteMapping - cannot work in this context as it first invokes 'get' and then 'delete'
    @RequestMapping(value = "/client/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteClient(@PathVariable Integer id){
        clientService.delete(id);
        return "redirect:/clients";
    }

    @GetMapping("/clientDetails/{id}")
    public String detailsClient(@PathVariable Integer id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "/parameters/clientDetails";
    }
}
