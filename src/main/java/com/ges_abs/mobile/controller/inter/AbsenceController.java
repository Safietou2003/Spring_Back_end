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
    @GetMapping("/pagination")
    public ResponseEntity<Map<String, Object>> getAllAbsences(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        Page<Absence> pageAbsences = absenceService.findAllPaginate(page, size);
        Map<String, Object> response = new HashMap<>();
        response.put("absences", pageAbsences.getContent());
        response.put("currentPage", pageAbsences.getNumber());
        response.put("totalItems", pageAbsences.getTotalElements());
        response.put("totalPages", pageAbsences.getTotalPages());
        return ResponseEntity.ok(response);
    }

