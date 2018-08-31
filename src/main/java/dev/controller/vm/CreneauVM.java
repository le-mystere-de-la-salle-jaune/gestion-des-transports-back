package dev.controller.vm;

public class CreneauVM {

	private DateVM debut;
	private DateVM fin;
	
	public CreneauVM(){
		
	}
	
	public CreneauVM(DateVM debut, DateVM fin) {
		super();
		this.debut = debut;
		this.fin = fin;
	}
	public DateVM getDebut() {
		return debut;
	}
	public void setDebut(DateVM debut) {
		this.debut = debut;
	}
	public DateVM getFin() {
		return fin;
	}
	public void setFin(DateVM fin) {
		this.fin = fin;
	}
	
	
}
