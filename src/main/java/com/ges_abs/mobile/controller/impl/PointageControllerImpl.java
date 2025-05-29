package com.ges_abs.mobile.controller.impl;

import com.ges_abs.web.controllers.inter.SessionController;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class PointageControllerImpl implements PointageController {
  @PostMapping("/pointer")
  public ResponseEntity<?> pointerEtudiant(@RequestParam String matricule, @RequestParam String sessionId) {
    return pointageService.pointerEtudiant(matricule, sessionId);
  }
}
