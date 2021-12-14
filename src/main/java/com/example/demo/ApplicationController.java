package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    // DASHBOARD
    @GetMapping("/index")           public String home(){ return "index"; }

    // FORMS
    @GetMapping("/form_component")  public String formComponent(){
        return "form_component";
    }
    @GetMapping("/form_validation") public String formValidation(){
        return "form_validation";
    }

    // UI FEATURES
    @GetMapping("/elements")        public String elements(){
        return "general";
    }
    @GetMapping("/general")         public String general(){
        return "general";
    }
    @GetMapping("/buttons")         public String buttons(){
        return "buttons";
    }
    @GetMapping("/grids")           public String grids(){
        return "grids";
    }

    // WIDGETS
    @GetMapping("/widgets")         public String widget(){
        return "widgets";
    }

    // CHARTS
    @GetMapping("/chart-chartjs")   public String charts(){
        return "chart-chartjs";
    }

    // TABLES
    @GetMapping("/basic_table")     public String basicTable(){
        return "basic_table";
    }

    // PAGES
    @GetMapping("/profile")         public String profile(){
        return "profile";
    }
    @GetMapping("/login")           public String login(){
        return "login";
    }
    @GetMapping("/contact")         public String contact(){
        return "contact";
    }
    @GetMapping("/blank")           public String blank(){
        return "blank";
    }
    @GetMapping("/404")             public String error(){ return "404"; }

    // HR
    @GetMapping("/hr")             public String hr(){ return "/hr/index"; }
}
