package dev.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation_vehicule_societe")
public class ReservationVehiculeSociete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date_debut")
	private LocalDateTime dateDebut;

	@Column(name = "date_fin")
	private LocalDateTime dateFin;

	@ManyToOne
	@JoinColumn(name = "vehicule")
	private Vehicule vehicule;
	
	@ManyToOne
	@JoinColumn(name = "collab")
	private Collaborateur collab;

	public ReservationVehiculeSociete() {
		super();
	}

	public ReservationVehiculeSociete(Long id, LocalDateTime dateDebut, LocalDateTime dateFin, Vehicule vehicule) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.vehicule = vehicule;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	public Collaborateur getCollab() {
		return collab;
	}

	public void setCollab(Collaborateur collab) {
		this.collab = collab;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dateDebut
	 */
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut
	 *            the dateDebut to set
	 */
	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDateTime getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin
	 *            the dateFin to set
	 */
	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the vehicule
	 */
	public Vehicule getVehicule() {
		return vehicule;
	}

	/**
	 * @param vehicule
	 *            the vehicule to set
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

}