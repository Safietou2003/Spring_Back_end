@RestController
@RequestMapping("/cours")
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
