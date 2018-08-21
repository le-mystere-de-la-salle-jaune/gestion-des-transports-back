package dev.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	private String numeroVoie;
	
	private String designationVoie;
	
	private String ville;
	
	private String codePostal;
	
	private String pays;
	
	public Adresse(){
		
	}
	
	public Adresse(String num, String street, String city, String zipCode, String country){
		numeroVoie = num;
		designationVoie = street;
		ville = city;
		codePostal = zipCode;
		pays = country;
	}

	public String getNumeroVoie() {
		return numeroVoie;
	}

	public void setNumeroVoie(String numeroVoie) {
		this.numeroVoie = numeroVoie;
	}

	public String getDesignationVoie() {
		return designationVoie;
	}

	public void setDesignationVoie(String designationVoie) {
		this.designationVoie = designationVoie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	
}