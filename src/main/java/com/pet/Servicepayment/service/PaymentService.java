package com.pet.Servicepayment.service;


import com.pet.Servicepayment.DTO.CardRequestDTO;
import com.pet.Servicepayment.mapper.CardMapper;
import com.pet.Servicepayment.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private CardMapper mapper;

    public Card create (CardRequestDTO  requestDTO){
        return mapper.toCard(requestDTO);
    }
}
