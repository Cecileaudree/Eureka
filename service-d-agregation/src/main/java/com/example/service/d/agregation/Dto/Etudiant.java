package com.example.service.d.agregation.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Etudiant {
    private Long Matricule;
    private String Nom;
    private  String Prenom;
    private String date_naissance;
    private String email;
    private String Classe;
    //private Number note;
}
