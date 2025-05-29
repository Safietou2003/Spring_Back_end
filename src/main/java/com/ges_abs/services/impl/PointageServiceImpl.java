package com.ges_abs.services.impl;

import com.ges_abs.services.inter.PointageService;
import org.springframework.stereotype.Service;

@Service
public class PointageServiceImpl implements PointageService {
@Override
public ResponseEntity<?> pointerEtudiant(String matricule, String sessionId) {
    if (pointageRepository.existsByMatriculeAndSessionId(matricule, sessionId)) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Déjà pointé");
    }

    Optional<Session> sessionOpt = sessionRepository.findById(sessionId);
    Optional<Etudiant> etudiantOpt = etudiantRepository.findByMatricule(matricule);

    if (sessionOpt.isEmpty() || etudiantOpt.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session ou étudiant introuvable");
    }

    Pointage pointage = new Pointage();
    pointage.setMatricule(matricule);
    pointage.setSessionId(sessionId);
    pointage.setDate(LocalDate.now());
    pointage.setHeure(LocalTime.now());
    pointage.setEtudiant(etudiantOpt.get());

    Pointage saved = pointageRepository.save(pointage);

    Session session = sessionOpt.get();
    session.getPointages().add(saved);
    sessionRepository.save(session);

    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
}
