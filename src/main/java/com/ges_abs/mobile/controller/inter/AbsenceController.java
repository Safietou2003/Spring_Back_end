@RestController
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @PostMapping
    public ResponseEntity<?> enregistrerAbsence(@RequestBody Map<String, String> request) {
        String matriculeEtudiant = request.get("matriculeEtudiant");
        String motif = request.get("motif");
        Absence absence = absenceService.enregistrerAbsence(matriculeEtudiant, motif);
        return ResponseEntity.ok(absence);
    }

    @GetMapping
    public ResponseEntity<?> getAbsences(@RequestParam String matriculeEtudiant) {
        List<Absence> absences = absenceService.getAbsencesByMatricule(matriculeEtudiant);
        return ResponseEntity.ok(absences);
    }
}
