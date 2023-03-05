package com.web.webproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "administration")
public class AdministrationController {

    @GetMapping(value = "AdminDetails")
    public void adminDetails(){
        System.out.println("Admin details...");
    }
}
