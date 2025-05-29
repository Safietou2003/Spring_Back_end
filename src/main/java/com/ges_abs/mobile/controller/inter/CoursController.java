package com.ges_abs.mobile.controller.inter;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Map;

@RestController
@RequestMapping("/api/cours")
@Tag(name = "Cours", description = "Opérations liées aux cours")

public class CoursController {

    @Autowired
    private CoursService coursService;

    @PostMapping
    @Operation(summary = "Créer un cours")
    public ResponseEntity<Cours> save(@RequestBody Cours cours) {
        return ResponseEntity.ok(coursService.save(cours));
    }

    @GetMapping
    @Operation(summary = "Lister tous les cours")
    public ResponseEntity<List<Cours>> findAll() {
        return ResponseEntity.ok(coursService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Trouver un cours par ID")
    public ResponseEntity<Cours> findById(@PathVariable String id) {
        return coursService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un cours par ID")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        coursService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
