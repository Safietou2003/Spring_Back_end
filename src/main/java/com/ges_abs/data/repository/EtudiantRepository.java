package com.ges_abs.data.repository;


import com.ges_abs.data.models.entity.Evenement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ges_abs.data.models.entity.Etudiant;

import java.util.Optional;

@Repository
public interface EtudiantRepository extends MongoRepository<Etudiant, String> {
    Optional<Etudiant> findByMatricule(String matricule);
    List<Etudiant> findByMatriculeContainingIgnoreCase(String matricule);

}

