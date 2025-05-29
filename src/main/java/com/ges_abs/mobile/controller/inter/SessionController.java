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
@RequestMapping("/api/session")
@Tag(name = "Sessions", description = "Opérations liées aux sessions")
public class SessionControllerImpl {

    @Autowired
    private SessionService sessionService;

    @PostMapping
    @Operation(summary = "Créer une session")
    public ResponseEntity<Session> create(@RequestBody Session session) {
        return new ResponseEntity<>(sessionService.create(session), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Lister toutes les sessions")
    public ResponseEntity<List<Session>> getAll() {
        return ResponseEntity.ok(sessionService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une session par ID")
    public ResponseEntity<Session> getById(@PathVariable String id) {
        return ResponseEntity.ok(sessionService.findById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une session")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        sessionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
