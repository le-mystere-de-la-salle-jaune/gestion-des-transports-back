package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.ReserverAfficherAnnonceVM;
import dev.domain.Adresse;
import dev.domain.Annonce;
import dev.domain.ReserverCovoiturageParticulier;
import dev.repository.AnnonceRepo;
import dev.repository.ReserverCovoiturageParticulierRepo;

@RestController
public class ReserverCovoiturageParticulierController {

	private ReserverCovoiturageParticulierRepo reserverCovoitRepo;
	private AnnonceRepo annonceRepo;
	
	public ReserverCovoiturageParticulierController(
			ReserverCovoiturageParticulierRepo reserverCovoitRepo, AnnonceRepo annonceRepo) {
		this.reserverCovoitRepo = reserverCovoitRepo;
		this.annonceRepo = annonceRepo;
	}
	
	@GetMapping("/reserver/{ville}")
	public ResponseEntity<List<ReserverAfficherAnnonceVM>> getListAnnonce(@PathVariable String ville){
		List<Annonce> annonces = annonceRepo.findAll();

		List<ReserverAfficherAnnonceVM> afficherAnnonceVM = new ArrayList<>();
		afficherAnnonceVM = annonces.stream().filter(annonce -> ville.equals(annonce.getAdresseDepart().getVille())).map(annonce -> { 
			ReserverAfficherAnnonceVM annonceVM = new ReserverAfficherAnnonceVM();
			annonceVM.setId(annonce.getId());
			annonceVM.setAdresse_depart(annonce.getAdresseDepart());
			annonceVM.setAdresse_arriver(annonce.getAdresseArrivee());
			annonceVM.setDepart(annonce.getDateDepart());
			annonceVM.setPlace(annonce.getNbPlace());
			annonceVM.setChauffeur(annonce.getCollaborateurs().getNom() + " " + annonce.getCollaborateurs().getPrenom());
			annonceVM.setVehicule(annonce.getVehiculeCovoitureur().getMarque() + " " + annonce.getVehiculeCovoitureur().getModele());
			return annonceVM;
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(afficherAnnonceVM);
	}
	
	@GetMapping("/reserver/{depart}/{arriver}")
	public ResponseEntity<List<ReserverAfficherAnnonceVM>> getAnonces(@PathVariable String depart, @PathVariable String arriver){
		List<Annonce> annonces = annonceRepo.findAll();
		
		List<ReserverAfficherAnnonceVM> afficherAnnonces = new ArrayList<>();
		afficherAnnonces = annonces.stream()
				.filter(annonce -> (depart.toLowerCase().equals(annonce.getAdresseDepart().getVille().toLowerCase()) && arriver.toLowerCase().equals(annonce.getAdresseArrivee().getVille().toLowerCase())))
				.map(annonce -> { 
					ReserverAfficherAnnonceVM annonceVM = new ReserverAfficherAnnonceVM();
					annonceVM.setId(annonce.getId());
					annonceVM.setAdresse_depart(annonce.getAdresseDepart());
					annonceVM.setAdresse_arriver(annonce.getAdresseArrivee());
					annonceVM.setDepart(annonce.getDateDepart());
					annonceVM.setPlace(annonce.getNbPlace());
					annonceVM.setChauffeur(annonce.getCollaborateurs().getNom() + " " + annonce.getCollaborateurs().getPrenom());
					annonceVM.setVehicule(annonce.getVehiculeCovoitureur().getMarque() + " " + annonce.getVehiculeCovoitureur().getModele());
					return annonceVM;
				}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(afficherAnnonces);
	}
	
}
