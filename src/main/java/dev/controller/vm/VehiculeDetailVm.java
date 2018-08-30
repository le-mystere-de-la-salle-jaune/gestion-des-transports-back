package dev.controller.vm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dev.domain.Vehicule;

public class VehiculeDetailVm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "photoUrl")
	private String photoUrl;

	@Column(name = "immatriculation")
	private String immatriculation;

	@Column(name = "marque")
	private String marque;

	@Column(name = "modele")
	private String modele;

	private String categorie;

	private String etat;

	public VehiculeDetailVm() {

	}

	public VehiculeDetailVm(Vehicule vehicule) {
		this.id = vehicule.getId();
		this.photoUrl = vehicule.getPhotoUrl();
		this.immatriculation = vehicule.getImmatriculation();
		this.marque = vehicule.getMarque();
		this.modele = vehicule.getModele();
		this.categorie = vehicule.getCategorie();
		this.etat = vehicule.getEtat();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
