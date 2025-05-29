package com.ges_abs.mobile.controller.impl;

import com.ges_abs.web.controllers.inter.EtudiantController;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@RestController
public class EtudiantControllerImpl implements EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @Override
    public ResponseEntity<Map<String, Object>> getAll(Pageable pageable) {
        return ResponseEntity.ok(etudiantService.getAllEtudiants(pageable));
    }

    @Override
    public ResponseEntity<Map<String, Object>> getByMatricule(String matricule) {
        return ResponseEntity.ok(etudiantService.getEtudiantByMatricule(matricule));
    }
}
