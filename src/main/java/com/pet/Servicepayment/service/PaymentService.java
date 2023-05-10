package com.pet.Servicepayment.service;


import com.pet.Servicepayment.DTO.CardRequestDTO;
import com.pet.Servicepayment.mapper.CardMapper;
import com.pet.Servicepayment.model.Card;
import com.pet.Servicepayment.model.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class PaymentService {
    @Autowired
    private CardMapper mapper;

    public Card create (CardRequestDTO  requestDTO){
        return mapper.toCard(requestDTO);
    }

    public Card get (int id){
        return new Card(
                "Bolek",
                true,
                new Tariff(21.0, 0.8, 50.0),
                OffsetDateTime.now().toString(),
                OffsetDateTime.now().toString(),
                20);
    }
}
