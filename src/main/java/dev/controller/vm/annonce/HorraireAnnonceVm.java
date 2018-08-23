package dev.controller.vm.annonce;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HorraireAnnonceVm {
	
	private int heureDepart;
	private int minuteDepart;
	private LocalDate dateDepart;
	
	public HorraireAnnonceVm(int heureDepart, int minuteDepart, LocalDate dateDepart) {
		super();
		this.heureDepart = heureDepart;
		this.minuteDepart = minuteDepart;
		this.dateDepart = dateDepart;
	}

	public HorraireAnnonceVm(){
		
	}
	
	public int getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(int heureDepart) {
		this.heureDepart = heureDepart;
	}

	public int getMinuteDepart() {
		return minuteDepart;
	}

	public void setMinuteDepart(int minuteDepart) {
		this.minuteDepart = minuteDepart;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalDateTime toHorraire() {
		return LocalDateTime.of(dateDepart.getYear(), dateDepart.getMonth(), dateDepart.getDayOfMonth(), heureDepart, minuteDepart);
	}
	
	

}
