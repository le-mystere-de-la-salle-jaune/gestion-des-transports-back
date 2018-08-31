package dev.controller.vm;

import java.time.LocalDateTime;

public class DateDebutFinVM {

	private LocalDateTime date_depart;
	private LocalDateTime date_fin;
	
	
	
	public DateDebutFinVM() {
		super();
	}
	
	public DateDebutFinVM(LocalDateTime date_depart, LocalDateTime date_fin) {
		super();
		this.date_depart = date_depart;
		this.date_fin = date_fin;
	}
	public LocalDateTime getDate_depart() {
		return date_depart;
	}
	public void setDate_depart(LocalDateTime date_depart) {
		this.date_depart = date_depart;
	}
	public LocalDateTime getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(LocalDateTime date_fin) {
		this.date_fin = date_fin;
	}
	
	
	
}
