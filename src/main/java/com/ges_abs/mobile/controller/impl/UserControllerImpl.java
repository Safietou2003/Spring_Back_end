package com.ges_abs.mobile.controller.impl;

import com.ges_abs.web.controllers.inter.UserController;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@RestController
@RequestMapping("/users")
@Tag(name = "Utilisateurs", description = "Opérations liées aux utilisateurs")
public class UserControllerImpl {

    @Autowired
    private UserService userService;

    @GetMapping("/pagination")
    @Operation(summary = "Lister les utilisateurs avec pagination")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Liste paginée des utilisateurs"),
        @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    public ResponseEntity<Map<String, Object>> findAllPaginate(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        try {
            Page<User> pageUsers = userService.findAllPaginate(page, size);
            List<User> users = pageUsers.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("users", users);
            response.put("currentPage", pageUsers.getNumber());
            response.put("totalItems", pageUsers.getTotalElements());
            response.put("totalPages", pageUsers.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
