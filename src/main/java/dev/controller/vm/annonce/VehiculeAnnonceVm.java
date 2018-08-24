package dev.controller.vm.annonce;

import dev.domain.Categories;
import dev.domain.Vehicule;

public class VehiculeAnnonceVm {

	private String immatriculation;
	private String marque;
	private String model;
	private int nbPlace;

	public VehiculeAnnonceVm(String immatriculation, String marque, String model, int nbPlaces) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.model = model;
		this.nbPlace = nbPlaces;
	}

	public VehiculeAnnonceVm() {

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public Vehicule toVehicule() {
		return new Vehicule(immatriculation, marque, model, Categories.MINI_CITADINES);
	}

}
