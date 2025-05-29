package com.ges_abs.mobile.controller.inter;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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

