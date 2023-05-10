package com.pet.Servicepayment.controller;

import com.pet.Servicepayment.DTO.CardRequestDTO;
import com.pet.Servicepayment.model.Card;
import com.pet.Servicepayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PayController {
    private final PaymentService paymentService;

    @Autowired
    public PayController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/api/v1/home_page")
    @ResponseBody
    public String welcome() {
        return "Welcome to payment application";
    }

    @PostMapping(value = "/api/v1/card_template")
    @ResponseBody
    public Card createCard(@RequestBody CardRequestDTO requestDTO) {
        return paymentService.create(requestDTO);
    }

    @GetMapping(value = "/api/v1/card_template/{id}")
    @ResponseBody
    public Card getCardById(@PathVariable int id) {
        return paymentService.get(id);
    }
}
