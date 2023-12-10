package com.example.gestion.des.inscriptions.Controller;

import com.example.gestion.des.inscriptions.Dto.InscritReponse;
import com.example.gestion.des.inscriptions.Dto.InscritRequete;
import com.example.gestion.des.inscriptions.Entity.Inscrit;
import com.example.gestion.des.inscriptions.Services.InscritService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inscrit")
public class InscritController {

    @Autowired
    private InscritService inscritService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/controle")
    public boolean Verification(Long id){
        String url="http://localhost:8096/gestetudiant/api/etudiant/controle/"+id;
        boolean existe= restTemplate.getForObject(url,Boolean.class);

        return existe;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String create_Inscrit(@RequestBody InscritRequete inscritRequete){
        Boolean existe= Verification(inscritRequete.getMatricule());
        if(existe) {
             inscritService.crate_Inscrit(inscritRequete);
            String url_email="http://localhost:8096/gestetudiant/api/etudiant/email/"+inscritRequete.getMatricule();
            String email= restTemplate.getForObject(url_email,String.class);
            String reponse = restTemplate.postForObject("http://localhost:8096/email/email/send",email,String.class);
            return "reponse";

        }
        else {
            return "vous ne vous etes pas pré-inscrit";
        }
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<InscritReponse> getAllInscrit(){return  inscritService.getAllInscrit();}


}
