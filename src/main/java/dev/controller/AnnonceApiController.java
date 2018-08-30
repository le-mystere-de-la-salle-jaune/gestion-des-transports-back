package dev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.annonce.AnnonceVm;
import dev.domain.Annonce;
import dev.services.AnnonceService;

@RestController
@RequestMapping("/api")
public class AnnonceApiController {

	AnnonceService annonceService;

	public AnnonceApiController(AnnonceService annonceService) {
		this.annonceService = annonceService;
	}

	@RequestMapping(value = "/publier_annonce", method = RequestMethod.POST)
	public ResponseEntity<?> enregistrerAnnonce(@RequestBody AnnonceVm annonceToSave) {

		System.out.println(annonceToSave);
		Annonce annonceTemp = annonceToSave.toAnnonce();
		annonceTemp.setCollaborateurs(annonceService.getCollabByEmail(annonceToSave.getUserEmail()));
		annonceService.saveNewAnnonce(annonceTemp);

		return ResponseEntity.status(HttpStatus.OK).body("Annonce enregistrer.");
	}
	
	@RequestMapping(value = "/lister_annonce", method = RequestMethod.GET)
	public ResponseEntity<?> getAnnonceOfuser(@RequestHeader("email") String userEmail) {

		return ResponseEntity.status(HttpStatus.OK).body(annonceService.getAllAnnonceByEmail(userEmail));
	}

}