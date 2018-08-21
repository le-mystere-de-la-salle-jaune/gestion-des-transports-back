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

@Entity
@Table(name="reserver_covoit_particulier")
public class ReserverCovoiturageParticulier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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

}
