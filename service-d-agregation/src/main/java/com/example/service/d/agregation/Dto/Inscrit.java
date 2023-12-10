package com.example.service.d.agregation.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inscrit {
    private Long matricule;
    private String nom;
    private  String Prenom;
}
