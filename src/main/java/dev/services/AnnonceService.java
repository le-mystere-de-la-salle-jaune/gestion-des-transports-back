package dev.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.domain.Annonce;
import dev.domain.Collaborateur;
import dev.repository.AnnonceRepo;
import dev.repository.CollaborateurRepo;
import dev.repository.VehiculeRepo;

@Service
public class AnnonceService {
	
	AnnonceRepo annonceRepo;
	VehiculeRepo vehiculeRepo;
	CollaborateurRepo collabRepo;
	
	public AnnonceService(AnnonceRepo annonceRepo, VehiculeRepo vehiculeRepo, CollaborateurRepo collabRepo){
		this.annonceRepo = annonceRepo;
		this.vehiculeRepo = vehiculeRepo;
		this.collabRepo = collabRepo;
	}

	@Transactional
	public void saveNewAnnonce(Annonce annonce) {
		
		vehiculeRepo.save(annonce.getVehiculeCovoitureur());
		annonceRepo.save(annonce);
		
	}

	public Collaborateur getCollabByEmail(String userEmail) {
		return collabRepo.findByEmail(userEmail).orElse(null);
	}

}
