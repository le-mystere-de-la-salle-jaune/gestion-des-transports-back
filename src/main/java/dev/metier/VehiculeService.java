package dev.metier;

import java.util.ArrayList;
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

	public List<Vehicule> listerSociete() {
		List<Vehicule> listeVehicule = new ArrayList();
		List<Vehicule> listeVehiculeSociete = new ArrayList();
		listeVehicule = lister();
		for (Vehicule vh : listeVehicule) {
			if (vh.getSociete() == true) {
				listeVehiculeSociete.add(vh);
			}
		}
		return listeVehiculeSociete;
	}

	public void ajouter(Vehicule vehicule) {
		vehiculeRepository.save(vehicule);
	}

	public void maj(Vehicule vehicule) {
		if (findVehiculeById(vehicule.getId()) != null) {
			vehiculeRepository.save(vehicule);
		}
	}

	public void supprimer(Long id) {
		vehiculeRepository.deleteById(id);
	}

	public Vehicule findVehiculeById(Long id) {
		return vehiculeRepository.findById(id).orElse(null);
	}

}
