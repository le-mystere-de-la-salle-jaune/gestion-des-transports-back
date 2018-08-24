package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.CollaborateurChauffeurVM;
import dev.domain.Collaborateur;
import dev.metier.CollaborateurService;

@RestController
@RequestMapping(value = "/api/collaborateurs")
public class CollaborateurApiController {

	private CollaborateurService collaborateurService;

	public CollaborateurApiController(CollaborateurService collaborateurService) {
		this.collaborateurService = collaborateurService;
	}

	@GetMapping
	public ResponseEntity<List<Collaborateur>> lister() {
		List<Collaborateur> collabs = this.collaborateurService.lister();

		return ResponseEntity.status(HttpStatus.OK).body(collabs);
	}

	@GetMapping("/chauffeurs")
	public ResponseEntity<List<CollaborateurChauffeurVM>> listerChauffeurs() {
		List<Collaborateur> chauffeurs = this.collaborateurService.listerChauffeurs();
		List<CollaborateurChauffeurVM> listeCollaborateurChauffeurVm = chauffeurs.stream()
				.map(unChauffeur -> new CollaborateurChauffeurVM(unChauffeur)).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(listeCollaborateurChauffeurVm);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CollaborateurChauffeurVM> afficherChauffeur(@PathVariable Long id) throws Exception {

		Collaborateur collab = this.collaborateurService.findCollaborateurById(id);
		CollaborateurChauffeurVM chauffeur = new CollaborateurChauffeurVM(collab);
		return ResponseEntity.status(HttpStatus.OK).body(chauffeur);
	}

	@GetMapping("/chauffeurs/{matricule}")
	public ResponseEntity<CollaborateurChauffeurVM> afficherChauffeur(@PathVariable String matricule) throws Exception {

		Collaborateur collab = this.collaborateurService.findCollaborateurByMatricule(matricule);
		CollaborateurChauffeurVM chauffeur = new CollaborateurChauffeurVM(collab);
		return ResponseEntity.status(HttpStatus.OK).body(chauffeur);
	}

	@PutMapping("/chauffeurs")
	public ResponseEntity<Collaborateur> update(@RequestBody String matricule) {
		Collaborateur c = collaborateurService.findCollaborateurByMatricule(matricule);
		collaborateurService.ajouterChauffeur(c);
		return ResponseEntity.status(HttpStatus.OK).body(c);

	}

}
