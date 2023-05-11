package com.pet.Servicepayment.mapper;

import com.pet.Servicepayment.DTO.CardRequestDTO;
import com.pet.Servicepayment.model.Card;
import com.pet.Servicepayment.model.Tariff;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class CardMapper {
    public Card toCard(CardRequestDTO requestDTO) {
        return new Card
                (requestDTO.getName(),
                        requestDTO.isActive(),
                        new Tariff(requestDTO.getTariff().getIssueCost(),
                                requestDTO.getTariff().getServiceCost(),
                                requestDTO.getTariff().getReissueCost()),
                        OffsetDateTime.now().toString(),
                        OffsetDateTime.now().toString(),
                        1);
    }
}
