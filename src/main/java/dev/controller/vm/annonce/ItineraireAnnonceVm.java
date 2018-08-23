package dev.controller.vm.annonce;

public class ItineraireAnnonceVm {

	private AdresseVm adresseDep;
	private AdresseVm adresseArr;
	private int dist;
	private String duree;
	

	public ItineraireAnnonceVm(){
		
	}
	
	
	public ItineraireAnnonceVm(AdresseVm adresseDep, AdresseVm adresseArr, int dist, String duree) {
		super();
		this.adresseDep = adresseDep;
		this.adresseArr = adresseArr;
		this.dist = dist;
		this.duree = duree;
	}

	public AdresseVm getAdresseDep() {
		return adresseDep;
	}

	public void setAdresseDep(AdresseVm adresseDep) {
		this.adresseDep = adresseDep;
	}

	public AdresseVm getAdresseArr() {
		return adresseArr;
	}

	public void setAdresseArr(AdresseVm adresseArr) {
		this.adresseArr = adresseArr;
	}


	public int getDist() {
		return dist;
	}


	public void setDist(int dist) {
		this.dist = dist;
	}


	public String getDuree() {
		return duree;
	}


	public void setDuree(String duree) {
		this.duree = duree;
	}
	
	
}
