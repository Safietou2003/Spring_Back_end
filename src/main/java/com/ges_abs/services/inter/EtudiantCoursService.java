package com.ges_abs.service;

import com.ges_abs.data.models.entity.EtudiantCours;
import java.util.List;

public interface EtudiantCoursService {
    EtudiantCours save(EtudiantCours etudiantCours);
    List<EtudiantCours> findAll();
    EtudiantCours findById(String id);
    void deleteById(String id);
}
