package dev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		List<Collaborateur> collaborateurs = this.collaborateurService.lister();
		return ResponseEntity.status(HttpStatus.OK).body(collaborateurs);
	}

	@GetMapping("/chauffeur")
	public ResponseEntity<List<Collaborateur>> listerChauffeurs() {
		List<Collaborateur> chauffeurs = this.collaborateurService.listerChauffeurs();
		return ResponseEntity.status(HttpStatus.OK).body(chauffeurs);
	}

	/*
	 * @GetMapping("/{id}") public ResponseEntity<Vehicule>
	 * afficherVehicule(@PathVariable Long id) throws Exception {
	 * 
	 * Vehicule vehicule = this.vehiculeService.findVehiculeById(id); return
	 * ResponseEntity.status(HttpStatus.OK).body(vehicule); }
	 * 
	 * @PostMapping public ResponseEntity<Vehicule> creer(@RequestBody Vehicule
	 * vehicule) { Vehicule v = new Vehicule(vehicule.getImmatriculation(),
	 * vehicule.getMarque(), vehicule.getModele());
	 * v.setPhotoUrl(vehicule.getPhotoUrl());
	 * v.setCategorie(vehicule.getCategorie());
	 * v.setPlaces(vehicule.getPlaces()); v.setSociete(vehicule.getSociete());
	 * vehiculeService.ajouter(v);
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).body(v);
	 * 
	 * }
	 * 
	 * @PutMapping public ResponseEntity<Vehicule> update(@RequestBody Vehicule
	 * vehicule) { Vehicule v =
	 * vehiculeService.findVehiculeById(vehicule.getId());
	 * v.setImmatriculation(vehicule.getImmatriculation());
	 * v.setMarque(vehicule.getMarque()); v.setModele(vehicule.getModele());
	 * v.setPhotoUrl(vehicule.getPhotoUrl());
	 * v.setCategorie(vehicule.getCategorie());
	 * v.setPlaces(vehicule.getPlaces()); v.setSociete(vehicule.getSociete());
	 * vehiculeService.maj(v);
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).body(v);
	 * 
	 * }
	 * 
	 * @DeleteMapping("/{id}") public void supprimer(@PathVariable Long id)
	 * throws Exception {
	 * 
	 * if (this.vehiculeService.findVehiculeById(id) != null) {
	 * this.vehiculeService.supprimer(id); }
	 * 
	 * }
	 */

}
