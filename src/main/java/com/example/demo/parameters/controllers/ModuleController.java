package com.example.demo.parameters.controllers;

import com.example.demo.parameters.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ModuleController {

    @Autowired private ModuleService moduleService;
}
