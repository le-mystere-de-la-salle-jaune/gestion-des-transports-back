package dev.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Collaborateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;

	private String prenom;

	private String email;

	private String motDePasse;

	private String matricule;

	@OneToMany(mappedBy = "collaborateur", cascade = CascadeType.PERSIST)
	private List<PermisCollaborateur> permis;

	private String telephone;

	@OneToMany(mappedBy = "collaborateur", cascade = CascadeType.PERSIST)
	private List<RoleCollaborateur> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<RoleCollaborateur> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleCollaborateur> roles) {
		this.roles = roles;
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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public List<PermisCollaborateur> getPermis() {
		return permis;
	}

	public void setPermis(List<PermisCollaborateur> permis) {
		this.permis = permis;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
