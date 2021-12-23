package com.example.demo.parameters.services;

import com.example.demo.parameters.models.Supplier;
import com.example.demo.parameters.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> findAll(){ return supplierRepository.findAll(); }
    public void save(Supplier supplier){ supplierRepository.save(supplier); }
    public Supplier findById(Integer id){ return supplierRepository.findById(id).orElse(null); }
    public void delete(Integer id){ supplierRepository.deleteById(id); }
}
