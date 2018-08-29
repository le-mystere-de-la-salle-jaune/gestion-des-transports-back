package dev.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EtatVehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "collaborateur_id")
	private Vehicule vehicule;

	@Enumerated(EnumType.STRING)
	private Etat etat;

	public EtatVehicule() {
	}

	public EtatVehicule(Vehicule vehicule, Etat etat) {
		this.vehicule = vehicule;
		this.etat = etat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setRole(Etat etat) {
		this.etat = etat;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setCollaborateur(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
}
