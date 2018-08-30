package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.ReservationVehiculeSocieteVm;
import dev.domain.ReservationVehiculeSociete;
import dev.repository.CollaborateurRepo;
import dev.repository.ReservationVehiculeSocieteRepo;
import dev.services.VehiculeService;

@RestController
@RequestMapping(value = "/api/reservationsSociete")
public class ReservationVehiculeSocieteController {

	private ReservationVehiculeSocieteRepo resaVehiculeSocRepo;
	private VehiculeService vehiculeService;
	private CollaborateurRepo collaborateurRepo;

	public ReservationVehiculeSocieteController(ReservationVehiculeSocieteRepo resaVehiculeSocRepo,
			VehiculeService vehiculeService, CollaborateurRepo collaborateurRepo) {
		this.resaVehiculeSocRepo = resaVehiculeSocRepo;
		this.vehiculeService = vehiculeService;
		this.collaborateurRepo = collaborateurRepo;
	}

	// lister les reservations véhicule de société
	@GetMapping
	public ResponseEntity<List<ReservationVehiculeSocieteVm>> getReservations() {
		List<ReservationVehiculeSociete> reservationsVehiculeSoc = this.resaVehiculeSocRepo.findAll();
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

	/*
	 * @GetMapping("/{id}") public ResponseEntity<ReservationVehiculeSocieteVm>
	 * afficherReservationsParIdVehicule(@PathVariable Long id) throws Exception
	 * {
	 * 
	 * ReservationVehiculeSocieteVm resa =
	 * this.vehiculeService.findVehiculeById(id);
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).body(resa); }
	 */

}