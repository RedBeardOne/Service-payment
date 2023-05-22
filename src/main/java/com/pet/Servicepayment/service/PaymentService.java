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

    private CardMapper mapper;

    @Autowired
    public PaymentService(CardMapper mapper) {
        this.mapper = mapper;
    }

    public Card create(CardRequestDTO requestDTO) {
        return mapper.toCard(requestDTO);
    }

    public Card get(int id) {
        return new Card(
                "Bolek",
                true,
                new Tariff(21.0, 0.8, 50.0),
                "2023-05-16T12:34:50.487412+03:00",
                "2023-05-16T12:34:50.487412+03:00",
                20);
    }

    public Card update(int id, CardRequestDTO requestDTO) {
        return new Card(
                "Unabolek",
                false,
                new Tariff(0.0, 0.1, 20.0),
                "2023-05-16T12:34:50.487412+03:00",
                "2023-05-16T12:34:50.487412+03:00",
                99);
    }
}
