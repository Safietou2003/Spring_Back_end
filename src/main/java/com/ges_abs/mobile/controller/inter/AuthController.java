@RestController
@RequestMapping("/auth")
public class AuthController {

    @Operation(summary = "Authentification utilisateur")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Connexion réussie"),
        @ApiResponse(responseCode = "401", description = "Identifiants incorrects")
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
        if ("modousamb@ism.edu.sn".equals(loginRequest.getIdentifiant()) && 
            "password".equals(loginRequest.getMotDePasse())) {
            return ResponseEntity.ok(new AuthResponseDto(true, "modousamb@ism.edu.sn"));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants incorrects");
    }
}
