package com.example.demo.parameters.controllers;

import com.example.demo.parameters.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
}
