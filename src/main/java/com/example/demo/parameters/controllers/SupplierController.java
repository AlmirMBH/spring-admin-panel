package com.example.demo.parameters.controllers;

import com.example.demo.parameters.models.Supplier;
import com.example.demo.parameters.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class SupplierController {

    @Autowired private SupplierService supplierService;

    @GetMapping("/suppliers")
    public String findAll(Model model){
        List<Supplier> suppliers = supplierService.findAll();
        model.addAttribute("suppliers", suppliers);
        return "parameters/suppliers";
    }

    @GetMapping("/supplierAdd")
    public String addSupplier(){
        return "parameters/supplierAdd";
    }

    @PostMapping("/suppliers")
    public String saveSupplier(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/supplierEdit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        return "/parameters/supplierEdit";
    }

    @RequestMapping(value = "/suppliers/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String editSupplier(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    // @DeleteMapping - cannot work in this context as it first invokes 'get' and then 'delete'
    @RequestMapping(value = "/supplier/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteSupplier(@PathVariable Integer id){
        supplierService.delete(id);
        return "redirect:/suppliers";
    }

    @GetMapping("/supplierDetails/{id}")
    public String detailsSupplier(@PathVariable Integer id, Model model){
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        return "/parameters/supplierDetails";
    }
}
