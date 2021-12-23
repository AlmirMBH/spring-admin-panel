package com.example.demo.parameters.controllers;

import com.example.demo.parameters.models.Contact;
import com.example.demo.parameters.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    @Autowired private ContactService contactService;

    @GetMapping("/contacts")
    public String findAll(Model model){
        List<Contact> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);
        return "parameters/contacts";
    }

    @GetMapping("/contactAdd")
    public String addContact(){
        return "parameters/contactAdd";
    }

    @PostMapping("/contacts")
    public String saveContact(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/contactEdit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "/parameters/contactEdit";
    }

    @RequestMapping(value = "/contacts/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String editContact(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    // @DeleteMapping - cannot work in this context as it first invokes 'get' and then 'delete'
    @RequestMapping(value = "/contact/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteContact(@PathVariable Integer id){
        contactService.delete(id);
        return "redirect:/contacts";
    }

    @GetMapping("/contactDetails/{id}")
    public String detailsContact(@PathVariable Integer id, Model model){
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "/parameters/contactDetails";
    }
}
