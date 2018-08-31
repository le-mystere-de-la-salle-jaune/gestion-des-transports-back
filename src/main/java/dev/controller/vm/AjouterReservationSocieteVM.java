package dev.controller.vm;

import java.time.LocalDateTime;


public class AjouterReservationSocieteVM {


	private CreneauVM creneau;
	private Long vehicule;
	private String collab;
	
	
	
	public AjouterReservationSocieteVM() {
		super();
	}

	
	
	public AjouterReservationSocieteVM(CreneauVM creneau, Long vehicule, String collab) {
		super();
		this.creneau = creneau;
		this.vehicule = vehicule;
		this.collab = collab;
	}



	public CreneauVM getCreneau() {
		return creneau;
	}



	public void setCreneau(CreneauVM creneau) {
		this.creneau = creneau;
	}

	public Long getVehicule() {
		return vehicule;
	}
	public void setVehicule(Long vehicule) {
		this.vehicule = vehicule;
	}
	public String getCollab() {
		return collab;
	}
	public void setCollab(String collab) {
		this.collab = collab;
	}
	
	
	
}
