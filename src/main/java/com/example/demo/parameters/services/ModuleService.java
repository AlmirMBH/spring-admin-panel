package com.example.demo.parameters.services;

import com.example.demo.parameters.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;
}
