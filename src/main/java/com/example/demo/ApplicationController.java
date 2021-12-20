package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    // DASHBOARD
    @GetMapping("/index")           public String home(){ return "index"; }


    // DEPARTMENTS
    // ACCOUNTS
    @GetMapping("/accounts")        public String accounts(){ return "/accounts/index"; }
    // FLEET / VEHICLES
    @GetMapping("/fleet")           public String fleet(){ return "/fleet/index"; }
    // HELPDESK
    @GetMapping("/helpdesk")        public String helpdesk(){ return "/helpdesk/index"; }
    // HR
    @GetMapping("/hr")              public String hr(){ return "/hr/index"; }
    // PARAMETERS / SETTINGS
    @GetMapping("/parameters")      public String parameters(){ return "/parameters/index"; }
    // PAYROLL
    @GetMapping("/payroll")         public String payroll(){ return "/payroll/index"; }


    // ASSETS
    // FORMS
    @GetMapping("/form_component")  public String formComponent(){
        return "assets/form_component";
    }
    @GetMapping("/form_validation") public String formValidation(){
        return "assets/form_validation";
    }
    // UI FEATURES
    @GetMapping("/elements")        public String elements(){
        return "assets/general";
    }
    @GetMapping("/general")         public String general(){
        return "assets/general";
    }
    @GetMapping("/buttons")         public String buttons(){
        return "assets/buttons";
    }
    @GetMapping("/grids")           public String grids(){
        return "assets/grids";
    }
    // WIDGETS
    @GetMapping("/widgets")         public String widget(){
        return "assets/widgets";
    }
    // CHARTS
    @GetMapping("/chart-chartjs")   public String charts(){
        return "assets/chart-chartjs";
    }
    // TABLES
    @GetMapping("/basic_table")     public String basicTable(){
        return "assets/basic_table";
    }
    // PAGES
    @GetMapping("/profile")         public String profile(){
        return "assets/profile";
    }
    @GetMapping("/login")           public String login(){
        return "assets/login";
    }
    @GetMapping("/contact")         public String contact(){
        return "assets/contact";
    }
    @GetMapping("/blank")           public String blank(){
        return "assets/blank";
    }
    @GetMapping("/404")             public String error(){ return "assets/404"; }
}
