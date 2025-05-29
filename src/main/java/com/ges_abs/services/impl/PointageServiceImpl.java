package com.ges_abs.services.impl;

import com.ges_abs.services.inter.PointageService;
import org.springframework.stereotype.Service;

@Service
public class PointageServiceImpl implements PointageService {
@Override
public ResponseEntity<?> pointerEtudiant(String matricule, String sessionId) {
    if (pointageRepository.existsByMatriculeAndSessionId(matricule, sessionId)) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Étudiant déjà pointé pour cette session.");
    }

    Pointage pointage = new Pointage();
    pointage.setMatricule(matricule);
    pointage.setSessionId(sessionId);
    pointage.setDatePointage(LocalDateTime.now());

    pointageRepository.save(pointage);
    return ResponseEntity.ok("Pointage effectué avec succès.");
}

}
