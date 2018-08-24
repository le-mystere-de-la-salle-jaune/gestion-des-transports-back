package dev.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.CreerReservationVM;
import dev.controller.vm.ReserverAfficherAnnonceVM;
import dev.domain.Adresse;
import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.domain.ReserverCovoiturageParticulier;
import dev.repository.AnnonceRepo;
import dev.repository.CollegueRepo;
import dev.repository.ReserverCovoiturageParticulierRepo;

@RestController
public class ReserverCovoiturageParticulierController {

	private ReserverCovoiturageParticulierRepo reserverCovoitRepo;
	private AnnonceRepo annonceRepo;
	private CollegueRepo collegueRepo;
	
	public ReserverCovoiturageParticulierController(
			ReserverCovoiturageParticulierRepo reserverCovoitRepo, AnnonceRepo annonceRepo,CollegueRepo collegueRepo) {
		this.reserverCovoitRepo = reserverCovoitRepo;
		this.annonceRepo = annonceRepo;
		this.collegueRepo = collegueRepo;
	}
	
	@GetMapping("/reserver/creer/{ville}")
	public ResponseEntity<List<ReserverAfficherAnnonceVM>> getListAnnonce(@PathVariable String ville){
		List<Annonce> annonces = annonceRepo.findAll();
		
		List<ReserverAfficherAnnonceVM> afficherAnnonceVM = new ArrayList<>();
		afficherAnnonceVM = annonces.stream().filter(annonce -> (ville.toLowerCase().equals(annonce.getAdresseDepart().getVille().toLowerCase()) && annonce.getDateDepart().isAfter(LocalDateTime.now())))
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

		return ResponseEntity.status(HttpStatus.OK).body(afficherAnnonceVM);
	}
	
	@PutMapping("/reserver/creer")
	public ResponseEntity<CreerReservationVM> ajouterReservation(@RequestBody CreerReservationVM reservation){
		Adresse adresseDepart = new Adresse();
		adresseDepart.setCodePostal(reservation.getAdresse_depart().getCodePostal());
		adresseDepart.setDesignationVoie(reservation.getAdresse_depart().getDesignationVoie());
		adresseDepart.setNumeroVoie(reservation.getAdresse_depart().getNumeroVoie());
		adresseDepart.setPays(reservation.getAdresse_depart().getPays());
		adresseDepart.setVille(reservation.getAdresse_depart().getVille());
		
		Adresse adresseArriver = new Adresse();
		adresseArriver.setCodePostal(reservation.getAdresse_arriver().getCodePostal());
		adresseArriver.setDesignationVoie(reservation.getAdresse_arriver().getDesignationVoie());
		adresseArriver.setNumeroVoie(reservation.getAdresse_arriver().getNumeroVoie());
		adresseArriver.setPays(reservation.getAdresse_arriver().getPays());
		adresseArriver.setVille(reservation.getAdresse_depart().getVille());

		Annonce ann = annonceRepo.findById(reservation.getId_annonce()).get();
		Collegue collegue = collegueRepo.findById(reservation.getId_collegue()).get();
		//sauvegarde de la réservation
		reserverCovoitRepo.save(new ReserverCovoiturageParticulier(collegue, reservation.getDepart(), adresseDepart, adresseArriver, ann));
		//on retire 1 place à l'annonce
		ann.setNbPlace(ann.getNbPlace()-1);
		annonceRepo.save(ann);
		
		return ResponseEntity.ok().body(reservation);
		
	}
	
}
