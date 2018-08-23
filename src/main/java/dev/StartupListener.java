package dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Categories;
import dev.domain.Collaborateur;
import dev.domain.Permis;
import dev.domain.PermisCollaborateur;
import dev.domain.Role;
import dev.domain.RoleCollaborateur;
import dev.domain.Vehicule;
import dev.domain.Version;
import dev.metier.CollaborateurService;
import dev.repository.VehiculeRepo;
import dev.repository.VersionRepo;

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

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollaborateurService collaborateurService, VehiculeRepo vehiculeRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collaborateurService = collaborateurService;
		this.vehiculeRepo = vehiculeRepo;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {
		this.versionRepo.save(new Version(appVersion));

		// Création de deux utilisateurs

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
		col2.setMotDePasse(passwordEncoder.encode("superpass"));
		col2.setRoles(Arrays.asList(new RoleCollaborateur(col2, Role.ROLE_UTILISATEUR)));
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

		Vehicule vehicule4 = new Vehicule("https://www.ouicar.fr/media/283370-product", "IJ-789-KL", "Citroen", "308",
				Categories.BERLINES_TAILL_M, 5);
		this.vehiculeRepo.save(vehicule4);

	}

}
