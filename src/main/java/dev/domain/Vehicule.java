package dev.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 *         2 chiffres), une marque, un modele, une catégorie, un nombre de
 *         place.
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
	 * categorie : String, énumaration contenant les différentes catégories
	 */
	private String categorie;

	private String etat = Etat.EN_SERVICE.getLibelle();

	@Column(name = "places")
	private int places;

	@Column(name = "societe")
	boolean societe = false;

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

	public Vehicule(String immatriculation, String marque, String model, Categories categorie) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie.toString();
	}

	public Vehicule(String photoUrl, String immatriculation, String marque, String modele, Categories categorie,
			int places) {
		this.photoUrl = photoUrl;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie.getLibelle();
		this.places = places;
	}

	public Vehicule(String photoUrl, String immatriculation, String marque, String modele, Categories categorie,
			int places, boolean societe) {
		this.photoUrl = photoUrl;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie.getLibelle();
		this.places = places;
		this.societe = societe;
	}

	public Vehicule(String photoUrl, String immatriculation, String marque, String modele, Categories categorie,
			int places, boolean societe, String etat) {
		this.photoUrl = photoUrl;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie.getLibelle();
		this.places = places;
		this.societe = societe;
		this.etat = etat;
	}

	public Vehicule(String photoUrl, String immatriculation, String marque, String modele, Categories categorie,
			int places, String etat) {
		this.photoUrl = photoUrl;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie.getLibelle();
		this.places = places;
		this.societe = societe;
		this.etat = etat;
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
	 *            : definie la marque du vehicule
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
	 *            : definie le modele du vehicule
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * @return la catégorie du véhicule.
	 */
	public String getCategorie() {
		return this.categorie;
	}

	/**
	 * @param categorie
	 *            : définie la catégorie de la vehicule
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return le nombre de place du véhicule.
	 */
	public int getPlaces() {
		return this.places;
	}

	/**
	 * @param places
	 *            : définie le nombre de place du véhicule
	 */
	public void setPlaces(int places) {
		this.places = places;
	}

	/**
	 * @return true si le véhicule est un véhicule de société, false sinon.
	 */
	public boolean getSociete() {
		return this.societe;
	}

	/**
	 * @param societe
	 *            : définie si le véhicule est un véhicule de société ou non.
	 */
	public void setSociete(boolean societe) {
		this.societe = societe;
	}

	/**
	 * @return l'état du véhicule.
	 */
	public String getEtat() {
		return this.etat;
	}

	/**
	 * @param etat
	 *            : définie l'état du véhicule.
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}
}
