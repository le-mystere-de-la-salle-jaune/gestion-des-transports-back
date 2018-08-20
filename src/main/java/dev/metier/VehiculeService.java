package dev.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.domain.Vehicule;
import dev.repository.VehiculeRepo;

@Service
public class VehiculeService {

	private VehiculeRepo vehiculeRepository;

	public VehiculeService(VehiculeRepo vehiculeRepository) {
		super();
		this.vehiculeRepository = vehiculeRepository;
	}

	public List<Vehicule> lister() {
		return vehiculeRepository.findAll();
	}

	public void ajouter(Vehicule vehicule) {
		vehiculeRepository.save(vehicule);
	}

	public void maj(Vehicule vehicule) {
		if (findVehiculeById(vehicule.getId()) == null) {
			vehiculeRepository.save(vehicule);
		}
	}

	public void supprimer(Vehicule vehicule) {
		vehiculeRepository.delete(vehicule);
	}

	public Vehicule findVehiculeById(Long id) {
		return vehiculeRepository.findById(id).orElse(null);
	}

}
