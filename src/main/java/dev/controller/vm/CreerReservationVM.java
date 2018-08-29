package dev.controller.vm;

import java.time.LocalDateTime;

import dev.domain.Adresse;

public class CreerReservationVM {
	private Long id_annonce;
	private Long id_collegue;
	private LocalDateTime depart;
	private Adresse adresse_depart;
	private Adresse adresse_arriver;
	
	public CreerReservationVM() {
		super();
	}

	public CreerReservationVM(Long id_annonce, Long id_collegue, LocalDateTime depart, Adresse adresse_depart,
			Adresse adresse_arriver) {
		super();
		this.id_annonce = id_annonce;
		this.id_collegue = id_collegue;
		this.depart = depart;
		this.adresse_depart = adresse_depart;
		this.adresse_arriver = adresse_arriver;
	}

	public Long getId_annonce() {
		return id_annonce;
	}

	public void setId_annonce(Long id_annonce) {
		this.id_annonce = id_annonce;
	}

	public Long getId_collegue() {
		return id_collegue;
	}

	public void setId_collegue(Long id_collegue) {
		this.id_collegue = id_collegue;
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
	
	
}
