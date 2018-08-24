package dev.domain;

import java.time.LocalDateTime;
import java.util.Optional;

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

@Entity
@Table(name="reserver_covoit_particulier")
public class ReserverCovoiturageParticulier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_collaborateur")
    private Collegue collaborateurs;
	
	@Column(name="date_depart")
	private LocalDateTime dateDepart;
	
	/**
	 * Comme deux objets adresse sont présent pour l'annoncone, on redéfinis chacuns des champs.
	 */
	@AttributeOverrides({
	    @AttributeOverride(name="numeroVoie",column=@Column(name="numero_voie_dep")),
	    @AttributeOverride(name="designationVoie",column=@Column(name="designation_voie_dep")),
	    @AttributeOverride(name="ville",column=@Column(name="ville_dep")),
	    @AttributeOverride(name="codePostal",column=@Column(name="code_postal_dep")),
	    @AttributeOverride(name="pays",column=@Column(name="pays_dep"))
	})
	@Embedded
	private Adresse adresseDepart;
	
	@AttributeOverrides({
	    @AttributeOverride(name="numeroVoie",column=@Column(name="numero_voie_arr")),
	    @AttributeOverride(name="designationVoie",column=@Column(name="designation_voie_arr")),
	    @AttributeOverride(name="ville",column=@Column(name="ville_arr")),
	    @AttributeOverride(name="codePostal",column=@Column(name="code_postal_arr")),
	    @AttributeOverride(name="pays",column=@Column(name="pays_arr"))
	})
	@Embedded
	private Adresse adresseArrivee;
	
	@ManyToOne
	@JoinColumn(name = "id_annonce")
	private Annonce annonce;

	
	
	public ReserverCovoiturageParticulier() {
		super();
	}

	public ReserverCovoiturageParticulier(Collegue collaborateurs, LocalDateTime dateDepart, Adresse adresseDepart, Adresse adresseArrivee,Annonce annonce) {
		super();
		this.dateDepart = dateDepart;
		this.adresseDepart = adresseDepart;
		this.adresseArrivee = adresseArrivee;
		this.annonce = annonce;
		this.collaborateurs = collaborateurs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
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

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce optional) {
		this.annonce = optional;
	}

	public Collegue getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(Collegue collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	
	

}