package com.pet.Servicepayment.mapper;

import com.pet.Servicepayment.DTO.CardRequestDTO;
import com.pet.Servicepayment.model.Card;
import com.pet.Servicepayment.model.Tariff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CardMapperTest {


    private CardMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new CardMapper();
    }

    @Test
    void toCard() {
        CardRequestDTO requestDTO = new CardRequestDTO("Valid",
                true,
                new Tariff(
                        2.0,
                        3.0,
                        33.0));

        Card cardMapped = mapper.toCard(requestDTO);

        Card cardReturned = new Card(
                "Valid",
                true,
                new Tariff(
                        2.0,
                        3.0,
                        33.0),
                cardMapped.getCreatedAt(),
                cardMapped.getUpdatedAt(),
                1);

        assertEquals(cardMapped, cardReturned);
    }
}