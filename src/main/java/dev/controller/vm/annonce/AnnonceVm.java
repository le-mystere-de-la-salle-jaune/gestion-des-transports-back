package dev.controller.vm.annonce;

import dev.domain.Annonce;

public class AnnonceVm {
	
	private VehiculeAnnonceVm vehiculeAnnonce;
	private ItineraireAnnonceVm itineraireAnnonce;
	private HorraireAnnonceVm horraireAnnonce;
	
	
	public AnnonceVm(VehiculeAnnonceVm vehiculeAnnonce, ItineraireAnnonceVm itineraireAnnonce,
			HorraireAnnonceVm horraireAnnonce) {
		super();
		this.vehiculeAnnonce = vehiculeAnnonce;
		this.itineraireAnnonce = itineraireAnnonce;
		this.horraireAnnonce = horraireAnnonce;
	}
	
	public AnnonceVm(){
		
	}
	
	public String toString(){
		return vehiculeAnnonce.getMarque() + " " + horraireAnnonce.getDateDepart() + " " + itineraireAnnonce.getAdresseDep();
	}
	
	public VehiculeAnnonceVm getVehiculeAnnonce() {
		return vehiculeAnnonce;
	}
	public void setVehiculeAnnonce(VehiculeAnnonceVm vehiculeAnnonce) {
		this.vehiculeAnnonce = vehiculeAnnonce;
	}
	public ItineraireAnnonceVm getItineraireAnnonce() {
		return itineraireAnnonce;
	}
	public void setItineraireAnnonce(ItineraireAnnonceVm itineraireAnnonce) {
		this.itineraireAnnonce = itineraireAnnonce;
	}
	public HorraireAnnonceVm getHorraireAnnonce() {
		return horraireAnnonce;
	}
	public void setHorraireAnnonce(HorraireAnnonceVm horraireAnnonce) {
		this.horraireAnnonce = horraireAnnonce;
	}

	public Annonce toAnnonce() {

		Annonce annonceToReturn = new Annonce();
		annonceToReturn.setAdresseArrivee(itineraireAnnonce.getAdresseArr().toAdresse());
		annonceToReturn.setAdresseDepart(itineraireAnnonce.getAdresseDep().toAdresse());
		
		annonceToReturn.setVehiculeCovoitureur(vehiculeAnnonce.toVheicule());
		annonceToReturn.setNbPlace(vehiculeAnnonce.getNbPlace());
		
		annonceToReturn.setDateDepart(horraireAnnonce.toHorraire());
		
		
		
		return annonceToReturn;
	}
	
	

}
