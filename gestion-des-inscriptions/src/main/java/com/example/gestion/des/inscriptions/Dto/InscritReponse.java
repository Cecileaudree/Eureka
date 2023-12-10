package com.example.gestion.des.inscriptions.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscritReponse {
    private Long matricule;
    private String nom;
    private  String Prenom;
    private Number montant;
}
