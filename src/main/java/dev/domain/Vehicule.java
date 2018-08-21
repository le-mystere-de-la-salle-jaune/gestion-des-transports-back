package dev.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mtremion
 *
 *         Classe véhicule. Un véhicule contient : un ID auto incrémenté lors de
 *         l'entrée en BDD, une url internet d'une photo de la voiture, une
 *         plaque d'immatriculation au format XX-XXX-XX (2 chiffres, 3 lettres,
 *         2 chiffres), une marque, un modele, une catégorie, un propriétaire
 *
 */

@Entity
public class Vehicule {

	/**
	 * id : Long, généré automatiquement par la BDD
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "photoUrl")
	private String photoUrl;

	@Column(name = "immatriculation")
	private String immatriculation;

	@Column(name = "marque")
	private String marque;

	@Column(name = "modele")
	private String modele;

	/**
	 * categorie : Categories, énumaration contenant les différentes catégories
	 */
	@Enumerated(EnumType.STRING)
	private Categories categorie;

	public Vehicule() {

	}

	/**
	 * @param immatriculation
	 * @param marque
	 * @param modele
	 *
	 *            Instancie un véhicule avec 3 param
	 */
	public Vehicule(String immatriculation, String marque, String modele) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
	}

	/**
	 * @return l'id du véhicule.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param marque
	 *            : definie l'id de la voiture
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return l'adresse url de la photo du véhicule.
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * @param marque
	 *            : definie l'url de la photo de la voiture
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	/**
	 * @return la plaque d'immatriculation du véhicule.
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * @param marque
	 *            : definie la plaque d'immatriculation de la voiture
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**
	 * @return la marque du véhicule.
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque
	 *            : definie la marque de la voiture
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return le modèle du véhicule.
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * @param modele
	 *            : definie la catégorie de la voiture
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * @return la catégorie du véhicule.
	 */
	public Categories getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 *            : définie la catégorie de la voiture
	 */
	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}
}
