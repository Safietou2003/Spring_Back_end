@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentification", description = "Vérification")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Operation(summary = "Connexion utilisateur")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Connexion réussie ou échouée")
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

