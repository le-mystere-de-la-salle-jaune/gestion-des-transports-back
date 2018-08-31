package dev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.vm.annonce.AnnonceVm;
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

	public List<AnnonceVm> getAllAnnonceByEmail(String userEmail) {
		// TODO Auto-generated method stub
		Long temp = getCollabByEmail(userEmail).getId();
		System.out.println(temp);
		return annonceRepo.findAllbyEmail(temp).orElse(new ArrayList<>()).stream().map(ann -> ann.toVm()).collect(Collectors.toList());
		
	}

}
