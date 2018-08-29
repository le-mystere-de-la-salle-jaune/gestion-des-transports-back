package dev.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.DateDebutFinVM;
import dev.controller.vm.ReservationAfficherVehiculeSocieteVm;
import dev.controller.vm.ReservationVehiculeSocieteVm;
import dev.domain.ReservationVehiculeSociete;
import dev.domain.Vehicule;
import dev.repository.CollaborateurRepo;
import dev.repository.ReservationVehiculeSocieteRepo;
import dev.repository.VehiculeRepo;
import dev.services.VehiculeService;

@RestController
public class ReservationVehiculeSocieteController {

	private ReservationVehiculeSocieteRepo resaVehiculeSocRepo;
	private VehiculeRepo vehiculeRepo;
	private VehiculeService vehiculeService;
	private CollaborateurRepo collaborateurRepo;

	public ReservationVehiculeSocieteController(ReservationVehiculeSocieteRepo resaVehiculeSocRepo, VehiculeService vehiculeService,
			VehiculeRepo vehiculeRepo, CollaborateurRepo collaborateurRepo) {
		this.resaVehiculeSocRepo = resaVehiculeSocRepo;
		this.vehiculeRepo = vehiculeRepo;
		this.collaborateurRepo = collaborateurRepo;
		this.vehiculeService = vehiculeService;
	}

	// lister les reservations véhicule de société
	@GetMapping("/api/reservationsSociete")
	public ResponseEntity<List<ReservationVehiculeSocieteVm>> getReservations() {
		List<ReservationVehiculeSociete> reservationsVehiculeSoc = resaVehiculeSocRepo.findAll();
		List<ReservationVehiculeSocieteVm> reservationsVehiculeSocVm = reservationsVehiculeSoc.stream().map(uneResa -> {
			ReservationVehiculeSocieteVm resa = new ReservationVehiculeSocieteVm();
			resa.setId(uneResa.getId());
			resa.setDate_debut(uneResa.getDateDebut());
			resa.setDate_fin(uneResa.getDateFin());
			resa.setMarque(uneResa.getVehicule().getMarque());
			resa.setModele(uneResa.getVehicule().getModele());
			resa.setImmatriculation(uneResa.getVehicule().getImmatriculation());
			return resa;
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(reservationsVehiculeSocVm);
	}		
	
	@PostMapping("/api/listeVoitureSociete")
	public ResponseEntity<List<ReservationAfficherVehiculeSocieteVm>> getVoitureSociete(@RequestBody DateDebutFinVM date){
		List<Vehicule> vSociete = vehiculeService.listerSociete();
		List<ReservationVehiculeSociete> resaSociete = resaVehiculeSocRepo.findAll().stream()
				.filter(res ->	((date.getDate_depart().isAfter(res.getDateDebut()) && date.getDate_depart().isBefore(res.getDateFin()))
								|| (date.getDate_fin().isAfter(res.getDateDebut()) && date.getDate_fin().isBefore(res.getDateFin()))
								|| (date.getDate_depart().isBefore(res.getDateDebut()) && date.getDate_fin().isAfter(res.getDateFin()))
								)).map(resa -> resa).collect(Collectors.toList());
		
		List<ReservationAfficherVehiculeSocieteVm> vehicules = vSociete.stream().map(v -> {
			ReservationAfficherVehiculeSocieteVm res = new ReservationAfficherVehiculeSocieteVm();
			res.setId(v.getId());
			res.setImmatriculation(v.getImmatriculation());
			res.setMarque(v.getMarque());
			res.setModele(v.getModele());
			
			res.setDispo(!resaSociete.stream().filter(r -> r.getVehicule().getId().equals(v.getId())).findAny().isPresent());
			return res;
		} ).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(vehicules);
	}
	
	@GetMapping("/json")
	public ResponseEntity<DateDebutFinVM> test(){
		return ResponseEntity.status(HttpStatus.OK).body(new DateDebutFinVM(LocalDateTime.of(2018,10,9, 10, 0),LocalDateTime.of(2018,10,9, 11, 0)));
	}
}