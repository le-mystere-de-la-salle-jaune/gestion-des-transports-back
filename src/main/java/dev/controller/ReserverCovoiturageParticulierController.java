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
import dev.domain.Collaborateur;
import dev.domain.ReserverCovoiturageParticulier;
import dev.repository.AnnonceRepo;
import dev.repository.CollaborateurRepo;
import dev.repository.ReserverCovoiturageParticulierRepo;

@RestController
public class ReserverCovoiturageParticulierController {

	private ReserverCovoiturageParticulierRepo reserverCovoitRepo;
	private AnnonceRepo annonceRepo;
	private CollaborateurRepo collaborateurRepo;

	public ReserverCovoiturageParticulierController(ReserverCovoiturageParticulierRepo reserverCovoitRepo,
			AnnonceRepo annonceRepo, CollaborateurRepo collaborateurRepo) {
		this.reserverCovoitRepo = reserverCovoitRepo;
		this.annonceRepo = annonceRepo;
		this.collaborateurRepo = collaborateurRepo;
	}

	// lister les reservations
	@GetMapping("/api/reservations")
	public ResponseEntity<List<ReserverAfficherAnnonceVM>> getReservations() {
		List<ReserverCovoiturageParticulier> reservations = this.reserverCovoitRepo.findAll();
		List<ReserverAfficherAnnonceVM> reservationsVm = reservations.stream().map(uneResa -> {
			ReserverAfficherAnnonceVM resa = new ReserverAfficherAnnonceVM();
			resa.setAdresse_arriver(uneResa.getAdresseArrivee());
			resa.setAdresse_depart(uneResa.getAdresseDepart());
			resa.setChauffeur(uneResa.getCollaborateurs().getNom() + " " + uneResa.getCollaborateurs().getPrenom());
			resa.setDepart(uneResa.getDateDepart());
			resa.setId(uneResa.getId());
			resa.setPlace(uneResa.getAnnonce().getNbPlace());
			resa.setVehicule(uneResa.getAnnonce().getVehiculeCovoitureur().getMarque() + " "
					+ uneResa.getAnnonce().getVehiculeCovoitureur().getModele());
			return resa;
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(reservationsVm);
	}

	@GetMapping("/reserver/creer/{ville}")
	public ResponseEntity<List<ReserverAfficherAnnonceVM>> getListAnnonce(@PathVariable String ville) {
		List<Annonce> annonces = annonceRepo.findAll();

		List<ReserverAfficherAnnonceVM> afficherAnnonceVM = new ArrayList<>();
		afficherAnnonceVM = annonces.stream()
				.filter(annonce -> (ville.toLowerCase().equals(annonce.getAdresseDepart().getVille().toLowerCase())
						&& annonce.getDateDepart().isAfter(LocalDateTime.now())))
				.map(annonce -> {
					ReserverAfficherAnnonceVM annonceVM = new ReserverAfficherAnnonceVM();
					annonceVM.setId(annonce.getId());
					annonceVM.setAdresse_depart(annonce.getAdresseDepart());
					annonceVM.setAdresse_arriver(annonce.getAdresseArrivee());
					annonceVM.setDepart(annonce.getDateDepart());
					annonceVM.setPlace(annonce.getNbPlace());
					annonceVM.setChauffeur(
							annonce.getCollaborateurs().getNom() + " " + annonce.getCollaborateurs().getPrenom());
					annonceVM.setVehicule(annonce.getVehiculeCovoitureur().getMarque() + " "
							+ annonce.getVehiculeCovoitureur().getModele());
					return annonceVM;
				}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(afficherAnnonceVM);
	}

	@PutMapping("/reserver/creer")
	public ResponseEntity<CreerReservationVM> ajouterReservation(@RequestBody CreerReservationVM reservation) {
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
		Collaborateur collegue = collaborateurRepo.findById(reservation.getId_collegue()).get();
		// sauvegarde de la réservation
		reserverCovoitRepo.save(new ReserverCovoiturageParticulier(collegue, reservation.getDepart(), adresseDepart,
				adresseArriver, ann));
		// on retire 1 place à l'annonce
		ann.setNbPlace(ann.getNbPlace() - 1);
		annonceRepo.save(ann);

		return ResponseEntity.ok().body(reservation);

	}

}
