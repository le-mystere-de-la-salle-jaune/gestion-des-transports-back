package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.CollaborateurVM;
import dev.repository.CollaborateurRepo;

/**
 * WEB API d'authentification.
 *
 * Elle permet de récupérer les informations du collègue connecté.
 */
@RestController
public class AuthentificationController {

	private CollaborateurRepo collegueRepo;

	public AuthentificationController(CollaborateurRepo collegueRepo) {
		this.collegueRepo = collegueRepo;
	}

	@GetMapping("/me")
	public ResponseEntity<?> quiSuisJe() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return this.collegueRepo.findByEmail(email).map(CollaborateurVM::new).map(col -> ResponseEntity.ok(col))
				.orElse(ResponseEntity.badRequest().build());
	}
}
