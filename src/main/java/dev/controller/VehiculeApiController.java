package dev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Vehicule;
import dev.metier.VehiculeService;

@RestController("/api/vehicules")
@RequestMapping(value = "/api/vehicules")
public class VehiculeApiController {

	private VehiculeService vehiculeService;

	public VehiculeApiController(VehiculeService vehiculeService) {
		this.vehiculeService = vehiculeService;
	}

	@GetMapping
	public ResponseEntity<List<Vehicule>> lister() {
		List<Vehicule> vehicules = this.vehiculeService.lister();
		return ResponseEntity.status(HttpStatus.OK).body(vehicules);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vehicule> afficherVehicule(@PathVariable Long id) throws Exception {

		Vehicule vehicule = this.vehiculeService.findVehiculeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(vehicule);
	}

	@PostMapping
	public ResponseEntity<Vehicule> creer(@RequestBody Vehicule vehicule) {
		Vehicule v = new Vehicule(vehicule.getImmatriculation(), vehicule.getMarque(), vehicule.getModele());
		v.setPhotoUrl(vehicule.getPhotoUrl());
		v.setCategorie(vehicule.getCategorie());
		vehiculeService.ajouter(v);

		return ResponseEntity.status(HttpStatus.OK).body(v);

	}

	@PutMapping
	public ResponseEntity<Vehicule> update(@RequestBody Vehicule vehicule) {
		Vehicule v = vehiculeService.findVehiculeById(vehicule.getId());
		v.setImmatriculation(vehicule.getImmatriculation());
		v.setMarque(vehicule.getMarque());
		v.setModele(vehicule.getModele());
		v.setPhotoUrl(vehicule.getPhotoUrl());
		v.setCategorie(vehicule.getCategorie());
		vehiculeService.maj(v);

		return ResponseEntity.status(HttpStatus.OK).body(v);

	}

}
