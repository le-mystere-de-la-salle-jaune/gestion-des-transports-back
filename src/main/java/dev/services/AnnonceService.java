package dev.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.domain.Annonce;
import dev.repository.AnnonceRepo;
import dev.repository.VehiculeRepo;

@Service
public class AnnonceService {
	
	AnnonceRepo annonceRepo;
	VehiculeRepo vehiculeRepo;
	
	public AnnonceService(AnnonceRepo annonceRepo, VehiculeRepo vehiculeRepo){
		this.annonceRepo = annonceRepo;
		this.vehiculeRepo = vehiculeRepo;
	}

	@Transactional
	public void saveNewAnnonce(Annonce annonce) {
		
		vehiculeRepo.save(annonce.getVehiculeCovoitureur());
		annonceRepo.save(annonce);
		
	}

}
