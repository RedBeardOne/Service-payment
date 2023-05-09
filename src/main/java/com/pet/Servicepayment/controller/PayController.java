package com.pet.Servicepayment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
    @GetMapping(value = "/api/v1/home_page")
    public String welcome(){
        return "Welcome to payment application";
    }
}
