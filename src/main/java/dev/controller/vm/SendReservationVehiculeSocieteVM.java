package dev.controller.vm;

import java.time.LocalDateTime;

public class SendReservationVehiculeSocieteVM {

	private Long id;
	private LocalDateTime date_debut;
	private LocalDateTime date_fin;
	
	public SendReservationVehiculeSocieteVM(Long id, LocalDateTime date_debut, LocalDateTime date_fin) {
		super();
		this.id = id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(LocalDateTime date_debut) {
		this.date_debut = date_debut;
	}
	public LocalDateTime getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(LocalDateTime date_fin) {
		this.date_fin = date_fin;
	}
	
	
	
}
