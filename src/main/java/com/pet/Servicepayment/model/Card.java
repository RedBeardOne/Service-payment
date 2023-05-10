package com.pet.Servicepayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
   private String name;
   private boolean active;
   private Tariff tariff;
   private String createdAt;
   private String updatedAt;
   private int createdAtId;
}
