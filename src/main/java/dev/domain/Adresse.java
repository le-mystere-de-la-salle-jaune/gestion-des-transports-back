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

}
