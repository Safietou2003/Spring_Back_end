package com.ges_abs.data.repositories;

import com.ges_abs.data.models.entity.EtudiantCours;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantCoursRepository extends MongoRepository<EtudiantCours, String> {
    boolean existsByEtudiantIdAndCoursId(String etudiantId, String coursId);
}
