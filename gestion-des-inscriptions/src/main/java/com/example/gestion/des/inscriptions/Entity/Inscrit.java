package com.example.gestion.des.inscriptions.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Inscrit {
    @Id
    private Long matricule;
    private String nom;
    private  String Prenom;
    private Number montant;
}
