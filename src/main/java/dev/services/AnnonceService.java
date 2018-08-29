package dev.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.repository.AnnonceRepo;
import dev.repository.CollegueRepo;
import dev.repository.VehiculeRepo;

@Service
public class AnnonceService {
	
	AnnonceRepo annonceRepo;
	VehiculeRepo vehiculeRepo;
	CollegueRepo collegueRepo;
	
	public AnnonceService(AnnonceRepo annonceRepo, VehiculeRepo vehiculeRepo, CollegueRepo collegueRepo){
		this.annonceRepo = annonceRepo;
		this.vehiculeRepo = vehiculeRepo;
		this.collegueRepo = collegueRepo;
	}

	@Transactional
	public void saveNewAnnonce(Annonce annonce) {
		
		vehiculeRepo.save(annonce.getVehiculeCovoitureur());
		annonceRepo.save(annonce);
		
	}

	public Collegue getCollabByEmail(String userEmail) {
		return collegueRepo.findByEmail(userEmail).orElse(null);
	}

}
