package dev.metier;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import dev.domain.Collaborateur;
import dev.repository.CollaborateurRepo;

@Service
public class CollaborateurService {

	private CollaborateurRepo collaborateurRepository;

	public CollaborateurService(CollaborateurRepo CollaborateurRepository) {
		super();
		this.collaborateurRepository = CollaborateurRepository;
	}

	public List<Collaborateur> lister() {
		return collaborateurRepository.findAll();
	}

	public List<Collaborateur> listerChauffeurs() {
		return collaborateurRepository.findAll();
	}

	public void ajouter(Collaborateur Collaborateur) {
		collaborateurRepository.save(Collaborateur);
	}

	public void maj(Collaborateur Collaborateur) {
		if (findCollaborateurById(Collaborateur.getId()) != null) {
			collaborateurRepository.save(Collaborateur);
		}
	}

	public void supprimer(Long id) {
		collaborateurRepository.deleteById(id);
	}

	public Collaborateur findCollaborateurById(Long id) {
		return collaborateurRepository.findById(id).orElse(null);
	}

	public Collaborateur findCollaborateurByMatricule(String matricule) {
		return collaborateurRepository.findByMatricule(matricule).orElse(null);
	}

	public void creerMatricule(Collaborateur collab) {
		Random random = new Random();
		int randomNumber = random.nextInt(99 + 1 - 0) + 0;
		collab.setMatricule(collab.getPrenom().toLowerCase().charAt(0) + collab.getNom().toLowerCase() + randomNumber);
	}

	public void creerEmail(Collaborateur collab) {
		collab.setEmail(collab.getPrenom().toLowerCase() + "." + collab.getNom().toLowerCase() + "@hotmail.fr");
	}

	public List<Collaborateur> findByRole(String role) {
		return collaborateurRepository.findByRole(role).orElse(null);
	}

}
