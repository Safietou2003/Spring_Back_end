p@Service
public class PointageServiceImpl implements PointageService {

    @Autowired
    private PointageRepository pointageRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public ResponseEntity<?> pointerEtudiant(String matricule, String sessionId) {
        if (pointageRepository.existsByMatriculeAndSessionId(matricule, sessionId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Déjà pointé");
        }

        Optional<Etudiant> etudiantOpt = etudiantRepository.findByMatricule(matricule);
        Optional<Session> sessionOpt = sessionRepository.findById(sessionId);

        if (etudiantOpt.isEmpty() || sessionOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Étudiant ou session introuvable");
        }

        Pointage pointage = new Pointage();
        pointage.setMatricule(matricule);
        pointage.setDate(LocalDate.now());
        pointage.setHeure(LocalTime.now());
        pointage.setSession(sessionOpt.get());

        return ResponseEntity.ok(pointageRepository.save(pointage));
    }

    @Override
    public List<Pointage> getAll() {
        return pointageRepository.findAll();
    }
}
