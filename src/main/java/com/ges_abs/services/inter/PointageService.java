package com.ges_abs.services.inter;

public interface PointageService {
    ResponseEntity<?> pointerEtudiant(String matricule, String sessionId);
    List<Pointage> getAll();
}

