package dev.domain;

/**
 * @author mtremion
 *
 *         L'énumération Catégories correspond au segment automobile européen.
 *
 */

public enum Categories {

	MICRO_URBAINES("Micro urbaine"), MINI_CITADINES("Mini citadine"), CITADINES_POLYVALENTES(
			"Citadine polyvalente"), COMPACTES("Compact"), BERLINES_TAILLE_S("Berline taille S"), BERLINES_TAILL_M(
					"Berline taille M"), BERLINES_TAILL_L(
							"Berline taille L"), SUV_TT_PICKUP("SUV/Tout terrain/Pick-Up");

	private String libelle;

	Categories(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return this.libelle;
	}
}
