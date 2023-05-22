package com.pet.Servicepayment.service;

import com.pet.Servicepayment.DTO.CardRequestDTO;
import com.pet.Servicepayment.mapper.CardMapper;
import com.pet.Servicepayment.model.Card;
import com.pet.Servicepayment.model.Tariff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class PaymentServiceTest {

    private PaymentService paymentService;

    @Mock
    private CardMapper mapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentService = new PaymentService(mapper);
    }

    @Test
    void shouldTReturnCard() {
        CardRequestDTO requestDTO = new CardRequestDTO("Valid",
                true,
                new Tariff(
                        2.0,
                        3.0,
                        33.0));
        Card cardReturned = new Card(
                "Valid",
                true,
                new Tariff(
                        2.0,
                        3.0,
                        33.0),
                "2023-05-11T22:26:18.937562400+03:00",
                "2023-05-11T22:26:18.937562400+03:00",
                1);

        when(mapper.toCard(requestDTO)).thenReturn(cardReturned);
        Card card = paymentService.create(requestDTO);

        verify(mapper, times(1)).toCard(requestDTO);
        assertEquals(card, cardReturned);
    }


    @Test
    void shouldReturnCardById() {
        Card card = new Card(
                "Bolek",
                true,
                new Tariff(21.0, 0.8, 50.0),
                "2023-05-16T12:34:50.487412+03:00",
                "2023-05-16T12:34:50.487412+03:00",
                20);

        Card cardAfterCall = paymentService.get(1);

        assertEquals(card, cardAfterCall);
    }

    @Test
    void shouldUpdateCardById() {
        CardRequestDTO cardRequestDTO = new CardRequestDTO("Unabolek",
                false,
                new Tariff(0.0, 0.1, 20.0));
        Card card = new Card("Unabolek",
                false,
                new Tariff(0.0, 0.1, 20.0),
                "2023-05-16T12:34:50.487412+03:00",
                "2023-05-16T12:34:50.487412+03:00",
                99);

        paymentService.update(1, cardRequestDTO);
    }
}