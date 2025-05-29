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
    public ResponseEntity<Map<String, Object>> login(
            @RequestParam String login,
            @RequestParam String password
    ) {
        Map<String, Object> result = authService.login(login, password);
        return ResponseEntity.ok(result);
    }
}
