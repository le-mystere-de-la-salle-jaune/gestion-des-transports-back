package dev;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Adresse;
import dev.domain.Annonce;
import dev.domain.Categories;
import dev.domain.Collaborateur;
import dev.domain.Permis;
import dev.domain.PermisCollaborateur;
import dev.domain.ReservationVehiculeSociete;
import dev.domain.ReserverCovoiturageParticulier;
import dev.domain.Role;
import dev.domain.RoleCollaborateur;
import dev.domain.Vehicule;
import dev.domain.Version;
import dev.repository.AnnonceRepo;
import dev.repository.ReservationVehiculeSocieteRepo;
import dev.repository.ReserverCovoiturageParticulierRepo;
import dev.repository.VehiculeRepo;
import dev.repository.VersionRepo;
import dev.services.CollaborateurService;

/**
 * Code de démarrage de l'application. Insertion de jeux de données.
 */
@Component
public class StartupListener {

	private String appVersion;
	private VersionRepo versionRepo;
	private PasswordEncoder passwordEncoder;
	private CollaborateurService collaborateurService;
	private VehiculeRepo vehiculeRepo;
	private AnnonceRepo annonceRepo;
	private ReserverCovoiturageParticulierRepo resaRepo;
	private ReservationVehiculeSocieteRepo resaSocieteRepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollaborateurService collaborateurService, AnnonceRepo annonceRepo,
			VehiculeRepo vehiculeRepo, ReserverCovoiturageParticulierRepo resaRepo,
			ReservationVehiculeSocieteRepo resaSocieteRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collaborateurService = collaborateurService;
		this.vehiculeRepo = vehiculeRepo;
		this.annonceRepo = annonceRepo;
		this.resaRepo = resaRepo;
		this.resaSocieteRepo = resaSocieteRepo;

	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {
		this.versionRepo.save(new Version(appVersion));

		// Création de cinq utilisateurs

		Collaborateur col1 = new Collaborateur();
		col1.setNom("Admin");
		col1.setPrenom("DEV");
		col1.setEmail("admin@dev.fr");
		col1.setMotDePasse(passwordEncoder.encode("superpass"));
		col1.setRoles(Arrays.asList(new RoleCollaborateur(col1, Role.ROLE_ADMINISTRATEUR),
				new RoleCollaborateur(col1, Role.ROLE_UTILISATEUR)));
		;
		this.collaborateurService.ajouter(col1);

		Collaborateur col2 = new Collaborateur();
		col2.setNom("User");
		col2.setPrenom("DEV");
		col2.setEmail("user@dev.fr");
		this.collaborateurService.creerMatricule(col2);
		col2.setMotDePasse(passwordEncoder.encode("superpass"));
		col2.setRoles(Arrays.asList(new RoleCollaborateur(col2, Role.ROLE_UTILISATEUR)));
		col2.setPhotoUrl("http://nicolaspene.fr/wp-content/uploads/2012/09/troll-300x300.jpg");
		this.collaborateurService.ajouter(col2);

		Collaborateur col3 = new Collaborateur();
		col3.setNom("Pagnol");
		col3.setPrenom("Marcel");
		this.collaborateurService.creerEmail(col3);
		this.collaborateurService.creerMatricule(col3);
		col3.setPermis(Arrays.asList(new PermisCollaborateur(col3, Permis.PERMIS_B)));
		col3.setMotDePasse(passwordEncoder.encode("superpass"));
		col3.setRoles(Arrays.asList(new RoleCollaborateur(col3, Role.ROLE_UTILISATEUR),
				new RoleCollaborateur(col3, Role.ROLE_CHAUFFEUR)));
		col3.setTelephone("06 35 21 09 48");
		col3.setPhotoUrl(
				"https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Marcel_Pagnol_1931.jpg/260px-Marcel_Pagnol_1931.jpg");
		this.collaborateurService.ajouter(col3);

		Collaborateur col4 = new Collaborateur();
		col4.setNom("Pagny");
		col4.setPrenom("Florent");
		this.collaborateurService.creerEmail(col4);
		this.collaborateurService.creerMatricule(col4);
		List<String> permisCol4 = new ArrayList();
		col4.setPermis(Arrays.asList(new PermisCollaborateur(col4, Permis.PERMIS_A),
				new PermisCollaborateur(col4, Permis.PERMIS_B)));
		col4.setMotDePasse(passwordEncoder.encode("superpass"));
		col4.setRoles(Arrays.asList(new RoleCollaborateur(col4, Role.ROLE_UTILISATEUR),
				new RoleCollaborateur(col4, Role.ROLE_CHAUFFEUR)));
		col4.setTelephone("06 35 21 09 47");
		col4.setPhotoUrl(
				"https://www.ouest-france.fr/sites/default/files/styles/image-640x360-p/public/2017/01/15/florent-pagny-se-fait-voler-sa-porsche-par-de-faux-policiers.jpg?itok=eubSGZSE");
		this.collaborateurService.ajouter(col4);

		Collaborateur col5 = new Collaborateur();
		col5.setNom("Dion");
		col5.setPrenom("Celine");
		this.collaborateurService.creerEmail(col5);
		this.collaborateurService.creerMatricule(col5);
		col5.setPermis(Arrays.asList(new PermisCollaborateur(col5, Permis.PERMIS_A),
				new PermisCollaborateur(col5, Permis.PERMIS_B), new PermisCollaborateur(col5, Permis.PERMIS_C)));
		col5.setMotDePasse(passwordEncoder.encode("superpass"));
		col5.setRoles(Arrays.asList(new RoleCollaborateur(col5, Role.ROLE_UTILISATEUR),
				new RoleCollaborateur(col5, Role.ROLE_CHAUFFEUR)));
		col5.setTelephone("06 35 21 09 45");
		col5.setPhotoUrl(
				"https://img3.closermag.fr/var/closermag/storage/images/1/2/6/0/0/12600072/celine-dion-traverse-sale-moment-ces-dernieres-semaines_exact540x405_l.jpg");
		this.collaborateurService.ajouter(col5);

		Vehicule vehicule1 = new Vehicule(
				"https://rzpict1.blob.core.windows.net/images/autowereld.nl/RZCATWNL27446716/PEUGEOT-106-0.jpg",
				"AB-123-CD", "Peaugot", "106", Categories.CITADINES_POLYVALENTES, 5, true);
		this.vehiculeRepo.save(vehicule1);

		Vehicule vehicule2 = new Vehicule(
				"https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Peugeot_106_front_20090730.jpg/1200px-Peugeot_106_front_20090730.jpg",
				"EF-456-GH", "Renault", "207", Categories.BERLINES_TAILL_L, 5, true);
		this.vehiculeRepo.save(vehicule2);

		Vehicule vehicule3 = new Vehicule("https://www.ouicar.fr/media/283370-product", "IJ-789-KL", "Citroen", "308",
				Categories.BERLINES_TAILL_M, 5, true);
		this.vehiculeRepo.save(vehicule3);

		Vehicule vehicule4 = new Vehicule("https://www.ouicar.fr/media/283370-product", "IJ-777-KL", "Citroen", "309",
				Categories.BERLINES_TAILL_M, 5);
		this.vehiculeRepo.save(vehicule4);

		Vehicule v1 = new Vehicule("457-5874-44", "Citron", "Agrume 300", Categories.BERLINES_TAILL_L);
		vehiculeRepo.save(v1);

		Annonce ann = new Annonce();
		ann.setAdresseArrivee(new Adresse("2", "bd de la ville", "Paris", "76000", "France"));
		ann.setAdresseDepart(new Adresse("85", "Rue de la fritte", "Bruxelles", "ZDF-54", "Belgique"));
		ann.setCollaborateurs(col1);
		ann.setDateDepart(LocalDateTime.of(2019, 9, 25, 10, 20));
		ann.setVehiculeCovoitureur(vehicule4);
		ann.setNbPlace(4);
		annonceRepo.save(ann);

		Annonce ann2 = new Annonce();
		ann2.setAdresseArrivee(new Adresse("2", "bd de la ville", "Paris", "76000", "France"));
		ann2.setAdresseDepart(new Adresse("85", "Rue de la fritte", "Bruxelles", "ZDF-54", "Belgique"));
		ann2.setCollaborateurs(col1);
		ann2.setDateDepart(LocalDateTime.of(2014, 9, 25, 10, 20));
		ann2.setVehiculeCovoitureur(vehicule4);
		ann2.setNbPlace(4);
		annonceRepo.save(ann2);

		ReserverCovoiturageParticulier resa = new ReserverCovoiturageParticulier();
		resa.setAdresseArrivee(new Adresse("2", "bd de la ville", "Paris", "76000", "France"));
		resa.setAdresseDepart(new Adresse("85", "Rue de la fritte", "Bruxel", "ZDF-54", "Belgique"));
		resa.setAnnonce(ann);
		resa.setCollaborateurs(col2);
		resa.setDateDepart(LocalDateTime.of(2018, 12, 24, 10, 00));
		resa.setId(1L);
		resa.setStatut(true);
		resaRepo.save(resa);

		ReserverCovoiturageParticulier resa1 = new ReserverCovoiturageParticulier();
		resa1.setAdresseArrivee(new Adresse("2", "bd de la ville", "Paris", "76000", "France"));
		resa1.setAdresseDepart(new Adresse("85", "Rue de la fritte", "Bruxel", "ZDF-54", "Belgique"));
		resa1.setAnnonce(ann2);
		resa1.setCollaborateurs(col2);
		resa1.setDateDepart(LocalDateTime.of(2014, 12, 24, 10, 00));
		resa1.setId(2L);
		resa1.setStatut(true);
		resaRepo.save(resa1);

		ReserverCovoiturageParticulier resa2 = new ReserverCovoiturageParticulier();
		resa2.setAdresseArrivee(new Adresse("2", "bd de la ville", "Paris", "76000", "France"));
		resa2.setAdresseDepart(new Adresse("85", "Rue de la fritte", "Bruxel", "ZDF-54", "Belgique"));
		resa2.setAnnonce(ann2);
		resa2.setCollaborateurs(col2);
		resa2.setDateDepart(LocalDateTime.of(2014, 12, 24, 10, 00));
		resa2.setId(3L);
		resa2.setStatut(true);
		resaRepo.save(resa2);

		ReserverCovoiturageParticulier resa3 = new ReserverCovoiturageParticulier();
		resa3.setAdresseArrivee(new Adresse("2", "bd de la ville", "Paris", "76000", "France"));
		resa3.setAdresseDepart(new Adresse("85", "Rue de la fritte", "Bruxel", "ZDF-54", "Belgique"));
		resa3.setAnnonce(ann2);
		resa3.setCollaborateurs(col2);
		resa3.setDateDepart(LocalDateTime.of(2014, 12, 24, 10, 00));
		resa3.setId(4L);
		resa3.setStatut(true);
		resaRepo.save(resa3);

		ReserverCovoiturageParticulier resa4 = new ReserverCovoiturageParticulier();
		resa4.setAdresseArrivee(new Adresse("2", "bd de la ville", "Paris", "76000", "France"));
		resa4.setAdresseDepart(new Adresse("85", "Rue de la fritte", "Bruxel", "ZDF-54", "Belgique"));
		resa4.setAnnonce(ann2);
		resa4.setCollaborateurs(col2);
		resa4.setDateDepart(LocalDateTime.of(2014, 12, 24, 10, 00));
		resa4.setId(5L);
		resa4.setStatut(true);
		resaRepo.save(resa4);

		ReserverCovoiturageParticulier resa5 = new ReserverCovoiturageParticulier();
		resa5.setAdresseArrivee(new Adresse("2", "bd de la ville", "Paris", "76000", "France"));
		resa5.setAdresseDepart(new Adresse("85", "Rue de la fritte", "Bruxel", "ZDF-54", "Belgique"));
		resa5.setAnnonce(ann2);
		resa5.setCollaborateurs(col2);
		resa5.setDateDepart(LocalDateTime.of(2014, 12, 24, 10, 00));
		resa5.setId(6L);
		resa5.setStatut(true);
		resaRepo.save(resa5);

		ReservationVehiculeSociete resaSociete1 = new ReservationVehiculeSociete();
		resaSociete1.setDateDebut(LocalDateTime.of(2018, 12, 24, 10, 00));
		resaSociete1.setDateFin(LocalDateTime.of(2018, 12, 28, 10, 00));
		resaSociete1.setId(1L);
		resaSociete1.setVehicule(vehicule1);
		resaSociete1.setCollaborateurs(col2);
		resaSocieteRepo.save(resaSociete1);

		ReservationVehiculeSociete resaSociete2 = new ReservationVehiculeSociete();
		resaSociete2.setDateDebut(LocalDateTime.of(2014, 12, 24, 10, 00));
		resaSociete2.setDateFin(LocalDateTime.of(2014, 12, 28, 10, 00));
		resaSociete2.setId(2L);
		resaSociete2.setVehicule(vehicule1);
		resaSociete2.setCollaborateurs(col2);
		resaSocieteRepo.save(resaSociete2);
	}

}
