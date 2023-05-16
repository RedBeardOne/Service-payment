package com.pet.Servicepayment.DTO;

import com.pet.Servicepayment.model.Tariff;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardRequestDTO {
    private String name;
    private boolean active;
    private Tariff tariff;
}
