package com.pet.Servicepayment.DTO;

import com.pet.Servicepayment.model.Tariff;
import lombok.Getter;

@Getter
public class CardRequestDTO {
    private String name;
    private boolean active;
    private Tariff tariff;
}
