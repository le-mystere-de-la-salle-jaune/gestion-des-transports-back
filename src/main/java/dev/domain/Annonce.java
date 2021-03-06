package dev.domain;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.controller.vm.annonce.AdresseVm;
import dev.controller.vm.annonce.AnnonceVm;
import dev.controller.vm.annonce.HorraireAnnonceVm;
import dev.controller.vm.annonce.ItineraireAnnonceVm;
import dev.controller.vm.annonce.VehiculeAnnonceVm;

@Entity
@Table(name = "annonce")
public class Annonce {

	/**
	 * Usage : Long : id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_collaborateur")
	private Collaborateur collaborateurs;

	/**
	 * Comme deux objets adresse sont présent pour l'annoncone, on redéfinis
	 * chacuns des champs.
	 */
	@AttributeOverrides({ @AttributeOverride(name = "numeroVoie", column = @Column(name = "numero_voie_dep")),
			@AttributeOverride(name = "designationVoie", column = @Column(name = "designation_voie_dep")),
			@AttributeOverride(name = "ville", column = @Column(name = "ville_dep")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "code_postal_dep")),
			@AttributeOverride(name = "pays", column = @Column(name = "pays_dep")) })
	@Embedded
	private Adresse adresseDepart;

	@AttributeOverrides({ @AttributeOverride(name = "numeroVoie", column = @Column(name = "numero_voie_arr")),
			@AttributeOverride(name = "designationVoie", column = @Column(name = "designation_voie_arr")),
			@AttributeOverride(name = "ville", column = @Column(name = "ville_arr")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "code_postal_arr")),
			@AttributeOverride(name = "pays", column = @Column(name = "pays_arr")) })
	@Embedded
	private Adresse adresseArrivee;

	@ManyToOne
	@JoinColumn(name = "id_vehicule")
	private Vehicule vehiculeCovoitureur;

	@Column(name = "date_depart")
	private LocalDateTime dateDepart;

	@Column(name = "nombre_place")
	private int nbPlace;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collaborateur getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(Collaborateur collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public Adresse getAdresseDepart() {
		return adresseDepart;
	}

	public void setAdresseDepart(Adresse adresseDepart) {
		this.adresseDepart = adresseDepart;
	}

	public Adresse getAdresseArrivee() {
		return adresseArrivee;
	}

	public void setAdresseArrivee(Adresse adresseArrivee) {
		this.adresseArrivee = adresseArrivee;
	}

	public Vehicule getVehiculeCovoitureur() {
		return vehiculeCovoitureur;
	}

	public void setVehiculeCovoitureur(Vehicule vehiculeCovoitureur) {
		this.vehiculeCovoitureur = vehiculeCovoitureur;
	}

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public AnnonceVm toVm() {
		return new AnnonceVm(new VehiculeAnnonceVm(vehiculeCovoitureur.getImmatriculation(), vehiculeCovoitureur.getMarque(), vehiculeCovoitureur.getModele(), nbPlace)
				,new ItineraireAnnonceVm(new AdresseVm(adresseDepart.getNumeroVoie(), adresseDepart.getDesignationVoie(), adresseDepart.getVille(), adresseDepart.getCodePostal(), adresseDepart.getPays())
						,new AdresseVm(adresseArrivee.getNumeroVoie(), adresseArrivee.getDesignationVoie(), adresseArrivee.getVille(), adresseArrivee.getCodePostal(), adresseArrivee.getPays())
						, 0, "0h0mn")
				, new HorraireAnnonceVm(dateDepart.getHour(), dateDepart.getMinute(), dateDepart.toLocalDate()), collaborateurs.getEmail());
	}
}
