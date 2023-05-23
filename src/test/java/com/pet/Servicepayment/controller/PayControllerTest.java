package com.pet.Servicepayment.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pet.Servicepayment.DTO.CardRequestDTO;
import com.pet.Servicepayment.model.Card;
import com.pet.Servicepayment.model.Tariff;
import com.pet.Servicepayment.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class PayControllerTest {

    @Autowired
    private MockMvc mock;

    @MockBean
    private PaymentService service;


    @Test
    void welcome() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/api/v1/home_page")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome to payment application")));
    }

    @Test
    void shouldReturn200WhenCreateCard() throws Exception {
        String requestString = """
                {
                    "name": "Valid",
                    "active": true,
                    "tariff": {
                        "issueCost": 2.0,
                        "serviceCost": 3.0,
                        "reissueCost": 33.0
                    }
                }
                """;
        String responseString = """
                {
                    "name": "Valid",
                    "active": true,
                    "tariff": {
                        "issueCost": 2.0,
                        "serviceCost": 3.0,
                        "reissueCost": 33.0
                    },
                    "createdAt": "2023-05-16T13:15:42.412851600+03:00",
                    "updatedAt": "2023-05-16T13:15:42.412851600+03:00",
                    "createdAtId": 1
                }
                """;
        Card cardReturned = new Card(
                "Valid",
                true,
                new Tariff(
                        2.0,
                        3.0,
                        33.0),
                "2023-05-16T13:15:42.412851600+03:00",
                "2023-05-16T13:15:42.412851600+03:00",
                1);

        Mockito.when(service.create(any(CardRequestDTO.class))).thenReturn(cardReturned);

        mock.perform(MockMvcRequestBuilders.post("/api/v1/card_template")
                        .content(requestString)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(responseString));
    }

    @Test
    void shouldReturn204WhenUpdateCard() throws Exception {
        String updateRequestString = """
                {
                    "name": "Valid",
                    "active": true,
                    "tariff": {
                        "issueCost": 2.0,
                        "serviceCost": 3.0,
                        "reissueCost": 33.0
                    }
                }
                """;

        mock.perform(MockMvcRequestBuilders.patch("/api/v1/card_template/{id}", 1, updateRequestString)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(updateRequestString))
                .andExpect(status().isNoContent());
    }
}
