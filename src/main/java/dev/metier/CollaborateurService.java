package dev.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import dev.domain.Collaborateur;
import dev.domain.Role;
import dev.domain.RoleCollaborateur;
import dev.repository.CollaborateurRepo;
import dev.repository.RoleCollaborateurRepo;

@Service
public class CollaborateurService {

	private CollaborateurRepo collaborateurRepository;
	private RoleCollaborateurRepo roleCollaborateurRepo;

	public CollaborateurService(CollaborateurRepo collaborateurRepository,
			RoleCollaborateurRepo roleCollaborateurRepo) {
		super();
		this.collaborateurRepository = collaborateurRepository;
		this.roleCollaborateurRepo = roleCollaborateurRepo;
	}

	public List<Collaborateur> lister() {
		return collaborateurRepository.findAll();
	}

	public List<Collaborateur> listerChauffeurs() {
		List<Collaborateur> tousLesCollabs = collaborateurRepository.findAll();
		List<Collaborateur> touslesChauffeurs = new ArrayList<>();

		for (Collaborateur c : tousLesCollabs) {
			List<RoleCollaborateur> rolesC = c.getRoles();
			for (RoleCollaborateur rc : rolesC) {
				if (rc.getRole().toString().equals("ROLE_CHAUFFEUR")) {
					touslesChauffeurs.add(c);
				}
			}
		}

		return touslesChauffeurs;
	}

	public void ajouter(Collaborateur collaborateur) {
		collaborateurRepository.save(collaborateur);
	}

	public void ajouterChauffeur(Collaborateur collaborateur) {
		RoleCollaborateur roleChauffeur = new RoleCollaborateur(collaborateur, Role.ROLE_CHAUFFEUR);
		roleCollaborateurRepo.save(roleChauffeur);
	}

	public void maj(Collaborateur collaborateur) {
		if (findCollaborateurById(collaborateur.getId()) != null) {
			collaborateurRepository.save(collaborateur);
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

	public Collaborateur ajouterRoleChauffeur(Collaborateur collab) {

		RoleCollaborateur roleChauffeur = new RoleCollaborateur(collab, Role.ROLE_CHAUFFEUR);
		collab.getRoles().add(roleChauffeur);
		return collab;
	}

}
