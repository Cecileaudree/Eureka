package com.example.service.d.agregation.Controller;

import com.example.service.d.agregation.Dto.Etudiant;
import com.example.service.d.agregation.Dto.Inscrit;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("agregation")
public class CompositeController {

    @Autowired
    private RestTemplate restTemplate;

    public String url_Etudiant="http://localhost:8096/gestetudiant/api/etudiant";

    public String url_inscription="http://localhost:8096/gestinscrit/api/inscrit";

    //private Etudiant etudiant;

    @PostMapping("/enregistrement/etudiant")
    public String Enregistre_Etudiant(@RequestBody Etudiant etudiant){
        //String url_Etudiant="http://localhost:8090/api/etudiant/save";
        System.out.println(etudiant);
        //URI uri = UriComponentsBuilder.fromUriString(url_Etudiant).build().toUri();
        String reponse=restTemplate.postForObject(url_Etudiant+"/save",  etudiant , String.class);

        // String reponse=restTemplate.ex
        return reponse;
    }

    @GetMapping("/list/etudiant/inscrit")
    public List<Etudiant> list_etudiant_incrit(){
       // List <Etudiant> list_etudiant = restTemplate.getForObject("http://localhost:8090/api/etudiant/listEtud", List.class);

        ResponseEntity<List<Etudiant>> responseEntity = restTemplate.exchange(
                url_Etudiant+"/listEtud",
                org.springframework.http.HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Etudiant>>() {});
        List<Etudiant> listeEtudiants = responseEntity.getBody();
        //System.out.println(url_Etudiant+"/listEtud");
        ResponseEntity<List<Inscrit>> responseInscrit = restTemplate.exchange(
                url_inscription+"/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Inscrit>>() {});
        List<Inscrit> listeInscrits = responseInscrit.getBody();
        System.out.println(url_inscription+"/list");
        //String[] reponse= new String[]{restTemplate.getForObject("http://localhost:8090/api/etudiant/listEtud", String.class)};
        //List <Inscrit> list_inscrit=restTemplate.getForObject(url_inscription+"/list", List.class);
        List<Etudiant> list_etudiantinscrit= new ArrayList<Etudiant>();
        for( int i=0 ; i<listeInscrits.size(); i++ ){
            Inscrit inscrit= listeInscrits.get(i);
            for(int j=0; j<listeEtudiants.size();j++){
                Etudiant etudiant = listeEtudiants.get(j);
                if(inscrit.getMatricule() == etudiant.getMatricule()) {
                    list_etudiantinscrit.add(etudiant);
                }
            }
        }
        return listeEtudiants;
    }

    @GetMapping("/essaie")
    public String get(){
        return "Ok";
    }




}
