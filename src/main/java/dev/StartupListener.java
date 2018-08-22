package dev;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Categories;
import dev.domain.Collegue;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.domain.Vehicule;
import dev.domain.Version;
import dev.repository.CollegueRepo;
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
	private CollegueRepo collegueRepo;
	private VehiculeRepo vehiculeRepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollegueRepo collegueRepo, VehiculeRepo vehiculeRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.vehiculeRepo = vehiculeRepo;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {
		this.versionRepo.save(new Version(appVersion));

		// Création de deux utilisateurs

		Collegue col1 = new Collegue();
		col1.setNom("Admin");
		col1.setPrenom("DEV");
		col1.setEmail("admin@dev.fr");
		col1.setMotDePasse(passwordEncoder.encode("superpass"));
		col1.setRoles(Arrays.asList(new RoleCollegue(col1, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col1, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col1);

		Collegue col2 = new Collegue();
		col2.setNom("User");
		col2.setPrenom("DEV");
		col2.setEmail("user@dev.fr");
		col2.setMotDePasse(passwordEncoder.encode("superpass"));
		col2.setRoles(Arrays.asList(new RoleCollegue(col2, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col2);

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
