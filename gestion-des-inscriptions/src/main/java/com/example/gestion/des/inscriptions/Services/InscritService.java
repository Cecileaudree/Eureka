package com.example.gestion.des.inscriptions.Services;

import com.example.gestion.des.inscriptions.Dto.InscritReponse;
import com.example.gestion.des.inscriptions.Dto.InscritRequete;
import com.example.gestion.des.inscriptions.Entity.Inscrit;
import com.example.gestion.des.inscriptions.Repository.InscritRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InscritService {

    private final InscritRepository inscritRepository;

    public Inscrit crate_Inscrit(InscritRequete inscritRequete){
        Inscrit inscrit = Inscrit.builder()
                .matricule(inscritRequete.getMatricule())
                .nom(inscritRequete.getNom())
                .Prenom(inscritRequete.getPrenom())
                .build();
        return inscritRepository.save(inscrit);
    }

    public List<InscritReponse> getAllInscrit (){
        List<Inscrit> etudiantList= inscritRepository.findAll();
        return etudiantList.stream().map(this::mapToresponse).toList();
    }

    private InscritReponse mapToresponse(Inscrit inscrit){
        return InscritReponse.builder()
                .nom(inscrit.getNom())
                .Prenom(inscrit.getPrenom())
                .matricule(inscrit.getMatricule())
                .build();
    }

}
