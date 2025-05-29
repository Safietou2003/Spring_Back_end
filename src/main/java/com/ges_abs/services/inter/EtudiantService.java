package com.ges_abs.services.inter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ges_abs.data.models.entity.Etudiant;

public interface EtudiantService {

    Map<String, Object> getAllEtudiants(Pageable pageable);

    Map<String, Object> getEtudiantByMatricule(String matricule);
}
