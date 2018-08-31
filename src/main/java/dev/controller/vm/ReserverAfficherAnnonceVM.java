package dev.controller.vm;

import java.time.LocalDateTime;

import dev.domain.Adresse;
import dev.domain.ReserverCovoiturageParticulier;

public class ReserverAfficherAnnonceVM {

	private Long id;
	private LocalDateTime depart;
	private Adresse adresse_depart;
	private Adresse adresse_arriver;
	private String vehicule;
	private String chauffeur;
	private int place;
	private boolean statut;

	public ReserverAfficherAnnonceVM() {
	}

	public ReserverAfficherAnnonceVM(ReserverCovoiturageParticulier reservationVm) {
		this.id = reservationVm.getId();
		this.depart = reservationVm.getDateDepart();
		this.adresse_arriver = reservationVm.getAdresseArrivee();
		this.adresse_depart = reservationVm.getAdresseDepart();
		this.vehicule = reservationVm.getAnnonce().getVehiculeCovoitureur().getMarque() + " "
				+ reservationVm.getAnnonce().getVehiculeCovoitureur().getModele();
		this.chauffeur = reservationVm.getAnnonce().getCollaborateurs().getNom() + " "
				+ reservationVm.getAnnonce().getCollaborateurs().getPrenom();
		this.place = reservationVm.getAnnonce().getNbPlace();
		this.statut = reservationVm.getStatut();
	}

	public ReserverAfficherAnnonceVM(Long id, LocalDateTime depart, Adresse adresse_depart, Adresse adresse_arriver,
			String vehicule, String chauffeur, int place, boolean statut) {
		this.id = id;
		this.depart = depart;
		this.adresse_depart = adresse_depart;
		this.adresse_arriver = adresse_arriver;
		this.vehicule = vehicule;
		this.chauffeur = chauffeur;
		this.place = place;
		this.statut = statut;
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

	public boolean getStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

}
