package dev.controller.vm;

import java.time.LocalDateTime;

import dev.domain.Adresse;

public class ReserverAfficherAnnonceVM {

	private Long id;
	private LocalDateTime depart;
	private Adresse adresse_depart;
	private Adresse adresse_arriver;
	private String vehicule;
	private String chauffeur;
	private int place; 
	
	public ReserverAfficherAnnonceVM() {
	}
	
	public ReserverAfficherAnnonceVM(Long id, LocalDateTime depart, Adresse adresse_depart, Adresse adresse_arriver,
			String vehicule, String chauffeur, int place) {
		this.id = id;
		this.depart = depart;
		this.adresse_depart = adresse_depart;
		this.adresse_arriver = adresse_arriver;
		this.vehicule = vehicule;
		this.chauffeur = chauffeur;
		this.place = place;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDepart() {
		return depart;
	}
	public void setDepart(LocalDateTime depart) {
		this.depart = depart;
	}
	public Adresse getAdresse_depart() {
		return adresse_depart;
	}
	public void setAdresse_depart(Adresse adresse_depart) {
		this.adresse_depart = adresse_depart;
	}
	public Adresse getAdresse_arriver() {
		return adresse_arriver;
	}
	public void setAdresse_arriver(Adresse adresse_arriver) {
		this.adresse_arriver = adresse_arriver;
	}
	public String getVehicule() {
		return vehicule;
	}
	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
	}
	public String getChauffeur() {
		return chauffeur;
	}
	public void setChauffeur(String chauffeur) {
		this.chauffeur = chauffeur;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}
	
	
	
}
