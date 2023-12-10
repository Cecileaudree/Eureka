package com.example.gestion.des.inscriptions.Repository;

import com.example.gestion.des.inscriptions.Entity.Inscrit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface InscritRepository extends JpaRepository <Inscrit,Long> {
}
