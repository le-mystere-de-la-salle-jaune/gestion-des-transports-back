package dev.controller.vm;

import java.time.LocalDate;

public class DateVM {

	private LocalDate date;
	private int heure;
	private int minute;
	
	public DateVM(){
		
	}
	
	public DateVM(LocalDate date, int heure, int minute) {
		super();
		this.date = date;
		this.heure = heure;
		this.minute = minute;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	
}
