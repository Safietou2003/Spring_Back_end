@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentification", description = "Vérification")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Operation(summary = "Créer un utilisateur", description = "Créer utilisateur dans la base")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Utilisateur créé"),
        @ApiResponse(responseCode = "400", description = "Requête invalide")
    })

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByLoginAndPassword(
            loginRequest.getLogin(), loginRequest.getPassword()
        );

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants invalides");
        }
    }

