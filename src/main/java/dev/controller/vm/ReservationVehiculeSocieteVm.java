package dev.controller.vm;

import java.time.LocalDateTime;

public class ReservationVehiculeSocieteVm {

	private Long id;
	private LocalDateTime date_debut;
	private LocalDateTime date_fin;
	private String marque;
	private String modele;
	private String immatriculation;

	public ReservationVehiculeSocieteVm() {
		super();
	}

	public ReservationVehiculeSocieteVm(Long id, LocalDateTime date_debut, LocalDateTime date_fin, String marque,
			String modele, String immatriculation) {
		super();
		this.id = id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the date_debut
	 */
	public LocalDateTime getDate_debut() {
		return date_debut;
	}

	/**
	 * @param date_debut
	 *            the date_debut to set
	 */
	public void setDate_debut(LocalDateTime date_debut) {
		this.date_debut = date_debut;
	}

	/**
	 * @return the date_fin
	 */
	public LocalDateTime getDate_fin() {
		return date_fin;
	}

	/**
	 * @param date_fin
	 *            the date_fin to set
	 */
	public void setDate_fin(LocalDateTime date_fin) {
		this.date_fin = date_fin;
	}

	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque
	 *            the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * @param modele
	 *            the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * @param immatriculation
	 *            the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

}