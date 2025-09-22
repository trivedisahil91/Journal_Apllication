package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Tag(name = "Health APIs")
public class HealthCheak {

    @GetMapping("/health")
    public String healthCheak(){
        return "App is Runnig.Devloped By Sahil Trivedi";
    }
    @GetMapping("/")
    public String redirectToSwagger() {
        // Redirect to swagger-ui
        return "redirect:/swagger-ui/index.html";
    }

}




