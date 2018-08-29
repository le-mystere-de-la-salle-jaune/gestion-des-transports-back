package dev.controller.vm;

import java.util.ArrayList;
import java.util.List;

import dev.domain.Collaborateur;
import dev.domain.PermisCollaborateur;

public class CollaborateurChauffeurVM {

	private String nom;

	private String prenom;

	private String email;

	private String matricule;

	private List<String> permis = new ArrayList<>();;

	private String telephone;

	private String photoUrl;

	public CollaborateurChauffeurVM() {

	}

	public CollaborateurChauffeurVM(Collaborateur collab) {
		this.nom = collab.getNom();
		this.prenom = collab.getPrenom();
		this.email = collab.getEmail();
		this.matricule = collab.getMatricule();
		List<PermisCollaborateur> permisCollab = collab.getPermis();
		for (PermisCollaborateur pc : permisCollab) {
			permis.add(pc.getPermis().toString());
		}
		this.telephone = collab.getTelephone();
		this.photoUrl = collab.getPhotoUrl();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public List<String> getPermis() {
		return permis;
	}

	public void setPermis(List<String> permis) {
		this.permis = permis;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String photoUrl) {
		this.telephone = telephone;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String telephone) {
		this.photoUrl = photoUrl;
	}

}
