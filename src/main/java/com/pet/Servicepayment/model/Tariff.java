package com.pet.Servicepayment.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tariff {
    private double issueCost;
    private double serviceCost;
    private double reissueCost;
}
