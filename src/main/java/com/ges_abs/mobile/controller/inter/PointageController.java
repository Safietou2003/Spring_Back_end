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
