package dev.controller.vm.annonce;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.domain.Adresse;

public class AdresseVm {
	
	@JsonProperty("street_number")
	private String numeroVoie;
	
	@JsonProperty("route")
	private String designationVoie;
	
	@JsonProperty("locality")
	private String ville;
	
	@JsonProperty("postal_code")
	private String codePostal;
	
	@JsonProperty("country")
	private String pays;
	
	public AdresseVm(){
		
	}

	
	public AdresseVm(String numeroVoie, String designationVoie, String ville, String codePostal, String pays) {
		super();
		this.numeroVoie = numeroVoie;
		this.designationVoie = designationVoie;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
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


	public Adresse toAdresse() {

		return new Adresse(numeroVoie,designationVoie,ville,codePostal,pays);
	}
	
	

}


