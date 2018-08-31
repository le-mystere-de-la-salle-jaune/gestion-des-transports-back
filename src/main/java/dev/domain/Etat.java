package dev.domain;

public enum Etat {
	HORS_SERVICE("Hors service"), EN_SERVICE("En service"), EN_REPARATION("En réparation");

	private String libelle;

	Etat(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return this.libelle;
	}
}
