package com.ges_abs.mobile.controller.inter;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RestController
@RequestMapping("/api/pointages")
@Tag(name = "Pointages", description = "Opérations liées au pointage des étudiants")
public class PointageController {

    @Autowired
    private PointageService pointageService;

    @PostMapping
    @Operation(summary = "Pointer un étudiant")
    public ResponseEntity<?> pointer(
        @RequestParam String matricule,
        @RequestParam String sessionId
    ) {
        return pointageService.pointerEtudiant(matricule, sessionId);
    }

    @GetMapping
    @Operation(summary = "Lister tous les pointages")
    public ResponseEntity<List<Pointage>> getAll() {
        return ResponseEntity.ok(pointageService.getAll());
    }
}
