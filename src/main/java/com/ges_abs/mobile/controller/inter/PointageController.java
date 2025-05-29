@RestController
@RequestMapping("/api/pointage")
public class PointageController {

    @Autowired
    private PointageService pointageService;

    @PostMapping
    public ResponseEntity<?> pointer(@RequestBody Map<String, String> request) {
        String matriculeEtudiant = request.get("matriculeEtudiant");
        String vigileId = request.get("vigileId");
        Pointage pointage = pointageService.enregistrerPointage(matriculeEtudiant, vigileId);
        return ResponseEntity.ok(pointage);
    }
    @PostMapping("/pointer")
    public ResponseEntity<?> pointerEtudiant(@RequestParam String matricule, @RequestParam String sessionId) {
        return pointageService.pointerEtudiant(matricule, sessionId);
    }

}
